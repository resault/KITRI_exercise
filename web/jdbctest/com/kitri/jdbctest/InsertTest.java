package com.kitri.jdbctest;

import java.sql.*;

public class InsertTest {
	
	public InsertTest() {
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
		InsertTest it = new InsertTest();
		String name = "홍길동";
		String id = "hong";
		
		Connection conn = null;
		Statement stmt = null;
		int cnt = 0;
		try {
//			2.
			conn = it.makeConnection();
//			insert into jdbctest (no, name, id, joindate)
//			values (jdbctest_no_seq.nextval, '안효인', 'java2', sysdate);
			
//			3.
			String sql = "";
			sql += "insert into jdbctest (no, name, id, joindate) \n";
			sql += "values (jdbctest_no_seq.nextval, '" + name + "', '" + id + "', sysdate)";
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
			System.out.println("data insert success!!!!!!!!!!!!!!!!!");
		else
			System.out.println("data insert fail!!!!!!!!!!!!!!!!!");
		
	}
	
}






















