package com.kitri.jdbctest;

import java.sql.*;

// resault 탈퇴
public class DeleteTest {

	public DeleteTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success !!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection makeConnection() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
		System.out.println("DB Connect Success !!!");
		return conn;
	}
	
	public static void main(String[] args) {
	
		DeleteTest dt = new DeleteTest();
		Connection conn = null;
		Statement  stmt = null;
		String id = "resault";
		int cnt = 0;
		
		try {
			conn = dt.makeConnection();
			String sql = "delete jdbctest where id='" + id + "'";
			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(stmt != null)
					stmt.close();
					if(conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		System.out.println(cnt +"개 data delete !!!");
		
		
	}
}
