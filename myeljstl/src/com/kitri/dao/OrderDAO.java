package com.kitri.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.dto.*;
import com.kitri.exception.AddException;

public class OrderDAO {
	
	/////// single tone
	private static OrderDAO orderDAO;
	
	static {
		orderDAO = new OrderDAO(); 
	}
	
	private OrderDAO() {}
	
	public static OrderDAO getOrderDAO() {
		return orderDAO;
	}


	/////// method

	public void insert(OrderInfo info) throws AddException{		// info가 line을 가지는 has a 관계로 설정하여 info만 들고다님
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "resault", "resault");

			insertInfo(conn, info);	// 주문기본정보 추가
			
			List<OrderLine> lines = info.getLines();
			insertLine(conn, lines);

			conn.setAutoCommit(false);	// autocommit 해제
			conn.commit();
		} catch (Exception e) {
			
			try {
				e.printStackTrace();
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new AddException("주문추가 오류" + e.getMessage());
			
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public void insertInfo(Connection conn, OrderInfo info) throws SQLException { //시퀀스 때문에 connection을 같이 써야 하므로 conn을 매개변수로 받음
		
		PreparedStatement pstmt = null;

		try {
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO ORDER_INFO(ORDER_NO, ORDER_ID) \n");
			sql.append("VALUES (ORDER_SEQ.NEXTVAL, ?) \n");
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, info.getCustomer().getId());
			
			pstmt.executeUpdate();
			
		}  finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	public void insertLine(Connection conn, List<OrderLine> lines) throws SQLException {
		
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO ORDER_LINE(ORDER_NO, ORDER_PROD_NO, ORDER_QUANTITY) \n");
		sql.append("VALUES (ORDER_SEQ.CURRVAL, ?, ?) \n");

		try {
			pstmt = conn.prepareStatement(sql.toString());

			for(OrderLine line : lines) {
	
				String prod_no = line.getProduct().getProdNo();
				int order_quantity = line.getOrder_quantity();
				
				pstmt.setString(1, prod_no);
				pstmt.setInt(2, order_quantity);
				
				//pstmt.executeUpdate();
				pstmt.addBatch();	//일괄처리에 추가
			}			
			pstmt.executeBatch();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}


	public List<OrderInfo> selectById(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<OrderInfo> list = new ArrayList<OrderInfo>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "resault", "resault");
			
			StringBuffer sql = new StringBuffer();
			sql.append("select info.order_no, order_dt, prod_no, prod_name, prod_price, order_quantity \n");
			sql.append("from order_info info join order_line line \n");
			sql.append("on info.order_no = line.order_no \n");
			sql.append("join product p \n");
			sql.append("on line.order_prod_no = p.prod_no \n");
			sql.append("where order_id = ? \n");
			sql.append("order by order_dt desc, prod_no \n");
			
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			OrderInfo info=null;
			OrderLine line=null;
			List<OrderLine> lines=null;
			int old_order_no = -1;
			while( rs.next() ) {
				int order_no = rs.getInt("order_no");
				if(old_order_no != order_no) {
					info = new OrderInfo();
					list.add(info);	//레퍼런스 자료형이기 때문에, info를 list에 추가하고, 아래에서 info의 set 메소드를 사용해도 되는거임!
					info.setOrder_no(order_no);
					info.setOrder_dt(rs.getDate("order_dt"));
					lines = new ArrayList<>();
					info.setLines(lines);
					old_order_no = order_no;
				}
				line = new OrderLine();
				String prod_no = rs.getString("prod_no");//상품번호
				String prod_name = rs.getString("prod_name");//명
				int prod_price = rs.getInt("prod_price");//가격
				Product p = new Product();
				p.setProdNo(prod_no);
				p.setProdName(prod_name);
				p.setProdPrice(prod_price);
				line.setProduct(p);
				line.setOrder_quantity(rs.getInt("order_quantity"));
				
				lines.add(line);//???
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}


}
	
	
	
	
	
