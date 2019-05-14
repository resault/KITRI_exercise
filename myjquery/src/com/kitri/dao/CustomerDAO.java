package com.kitri.dao;

import java.sql.*;
import java.util.List;

import com.kitri.dto.Customer;
import com.kitri.exception.NotFoundException;

public class CustomerDAO {

	public Customer selectById(String id) throws com.kitri.exception.NotFoundException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Customer c = null;
		
		try {
		
			//JDBC Driver Load
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//DB 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
			
			//SQL구문 DB서버로 송신
			String selectByIdSQL = "";
			selectByIdSQL += "select * /n";
			selectByIdSQL += "from customer /n";
			selectByIdSQL += "where id=? /n";

			pstmt = conn.prepareStatement(selectByIdSQL.toString());
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			//결과 처리
			if(rs.next()) {
				c = new Customer();
				c.setId(id);
				c.setName(rs.getString("name"));
				c.setPass(rs.getString("pass"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new NotFoundException(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NotFoundException(e.getMessage());
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(c != null) {
			return c;
		} else {
			throw new NotFoundException("아이디에 해당하는 고객이 없습니다.");
		}
	}
	
	
	public List<Customer> selectByName(String name){
		return null;
	}
	
	public List<Customer> selectAll() {
		return null;
	}
	
	public void insert(Customer c) {
		
	}
}
