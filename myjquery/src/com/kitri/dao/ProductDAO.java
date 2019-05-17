package com.kitri.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.dto.Product;
import com.kitri.dto.ProductCategory;
import com.kitri.exception.NotFoundException;

public class ProductDAO {

	//// singletone ////
	private static ProductDAO productDAO;
	
	static {
		productDAO = new ProductDAO();
	}
	
	private ProductDAO () {}
	
	public static ProductDAO getProductDAO() {
		return productDAO;
	}



	
	//// method ////
	
	
	// 전체 상품 조회
	public List<Product> selectAll() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = null;
		Product product = null;
		ProductCategory productCategory = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "resault", "resault");
			
			StringBuffer sql = new StringBuffer();
			sql.append("select cate_no, cate_name, prod_no, prod_name, prod_price, prod_detail \n");
			sql.append("from product p join product_category pc \n");
			sql.append("on p.prod_cate = pc.cate_no \n");
			sql.append("order by cate_no, prod_name \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<Product>();
			
			while(rs.next()) {
				
				product = new Product();
				productCategory = new ProductCategory();
				
				product.setProdNo(rs.getString("prod_no"));
				product.setProdName(rs.getString("prod_name"));
				product.setProdPrice(rs.getInt("prod_price"));
				product.setProdDetail(rs.getString("prod_detail"));
				
				productCategory.setCateNo(rs.getString("cate_no"));
				productCategory.setCateName(rs.getString("cate_name"));
				product.setProductCategory(productCategory);
				
				list.add(product);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	public Product SelectByNo(String no) throws com.kitri.exception.NotFoundException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product product = null;
		ProductCategory productCategory = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "resault", "resault");
			
			StringBuffer sql = new StringBuffer();
			sql.append("select prod_no, prod_name, prod_price, prod_detail \n");
			sql.append("from product \n");
			sql.append("where prod_no = ? \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				product = new Product();
				productCategory = new ProductCategory();
				
				product.setProdNo(rs.getString("prod_no"));
				product.setProdName(rs.getString("prod_name"));
				product.setProdPrice(rs.getInt("prod_price"));
				product.setProdDetail(rs.getString("prod_detail"));
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return product;
	}
	
}
