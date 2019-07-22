package com.kitri.jdbctest;

import java.sql.*;

//java2의 가입일을 현재시간으로 수정.
public class UpdateTest {
	
	public UpdateTest() {
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
		UpdateTest ut = new UpdateTest();
		String id = "김의연2";
		
		Connection conn = null;
		Statement stmt = null;
		int cnt = 0;
		try {
//			2.
			conn = ut.makeConnection();
//			update jdbctest set joindate = sysdate
//			where id = 'java2';
			
//			3.
			String sql = "";
			sql += "update jdbctest set joindate = sysdate \n";
			sql += "where name = '" + id + "'";
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
		
		System.out.println(cnt + "개 data update!!!!!!!!!!!!!!!!!");
		
	}
	
}
