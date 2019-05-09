package com.kitri.member.util;

import java.sql.*;

public class DBConnection {

	static {	//static 블록 초기화 : class가 로드될 때 최초에 한번 호출됨
		try {
			Class.forName(SiteConstance.DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection makeConnection() throws SQLException {
		return DriverManager.getConnection(SiteConstance.DB_URL, SiteConstance.DB_USERNAME, SiteConstance.DB_PASWORD);
	}
}
