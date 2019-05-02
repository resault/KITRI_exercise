package com.kitri.jdbctest;

import java.sql.*;

//java2인 사람 탈퇴
public class DeleteTest {

	public DeleteTest() {
		try {
//			1.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!!!!!!!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection makeConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
		System.out.println("DB Connection Success!!!!!!");
		return conn;
	}

	
	public static void main(String[] args) {
		DeleteTest dt = new DeleteTest();
		String id = "zave";
		
		Connection conn = null;
		Statement stmt = null;
		int cnt = 0;
		try {
//			2.
			conn = dt.makeConnection();
//			delete jdbctest 
//			where id = 'java2';
			
//			3.
			String sql = "";
			sql += "delete jdbctest \n";
			sql += "where id = '" + id + "'";
//			System.out.println(sql);
			stmt = conn.createStatement();
			
//			4.
			cnt = stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null)
					stmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(cnt != 0)
			System.out.println("data update success!!!!!!!!!!!!!!!!!");
		else
			System.out.println("data update fail!!!!!!!!!!!!!!!!!");
		
	}
	
}
