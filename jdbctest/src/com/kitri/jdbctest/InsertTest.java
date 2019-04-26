package com.kitri.jdbctest;

import java.sql.*;

public class InsertTest {

	public InsertTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	//driver loading
			System.out.println("Driver Loading Success !!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection makeConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");	//db connection
		System.out.println("DB Connection Success !!!");
		return conn;
	}
	
	
	
	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		String name = "정현정";
		String id = "resault";
		Connection conn = null;
		Statement stmt = null;
		int cnt = 0;
		try {
		
			conn = it.makeConnection();
			String sql = "";
			sql += "insert into jdbctest (no, name, id, joindate) \n";
			sql += "values (jdbctest_no_seq.nextval, '" + name + "', '" + id + "', sysdate)";
			stmt = conn.createStatement();	// sql 준비
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

		if(cnt !=0) {
			System.out.println("data insert success !!!");
		} else {
			System.out.println("data insert fail !!!");
		}
		
	}
}
