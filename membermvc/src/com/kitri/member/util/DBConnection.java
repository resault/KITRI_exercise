package com.kitri.member.util;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;

public class DBConnection {

//	static {	//static 블록 초기화 : class가 로드될 때 최초에 한번 호출됨
//		try {
//			Class.forName(SiteConstance.DB_DRIVER);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static Connection makeConnection() throws SQLException {
//		return DriverManager.getConnection(SiteConstance.DB_URL, SiteConstance.DB_USERNAME, SiteConstance.DB_PASWORD);
//	}
	
	public static Connection makeConnection() throws SQLException {
		
		try {
			Context ictx = new InitialContext();
			Context ctx = (Context)ictx.lookup("java:comp/env");
			DataSource ds = (DataSource)ctx.lookup("jdbc/kitri");
			return ds.getConnection();
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
