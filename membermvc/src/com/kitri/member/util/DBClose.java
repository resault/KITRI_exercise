package com.kitri.member.util;

import java.sql.*;

public class DBClose {
	
	//아래 close method들은 각 객체가 서로 간섭할 일이 없으므로 static 선언!
	
	public static void close(Connection conn, PreparedStatement pstmt) {	//method overloading
		
		try {
			if(pstmt != null)
				pstmt.close();
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, Statement stmt) {	//method overloading
		
		try {
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		
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
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {	//method overloading
		
		try {
			if(rs != null)
				rs.close();
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
}
