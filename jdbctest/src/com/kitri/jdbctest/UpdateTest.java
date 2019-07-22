package com.kitri.jdbctest;

import java.sql.*;

//resault의 가입일을 현재시간으로 수정
public class UpdateTest {
	
	public UpdateTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success !!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection makeConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
		System.out.println("DB Connect Sucess !!!");
		return conn;
	}
	
	
	public static void main(String[] args) {
		UpdateTest ut = new UpdateTest();
		Connection conn = null;
		Statement stmt = null;
		String id = "resault";
		int cnt = 0;
		try {
			conn = ut.makeConnection();
			stmt = conn.createStatement();
			
			String sql = "update jdbctest set joindate=sysdate where id='" + id + "'";
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
		
		System.out.println(cnt + "개 data update !!!");
	}
	
}
