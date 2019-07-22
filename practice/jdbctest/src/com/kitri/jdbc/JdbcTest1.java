package com.kitri.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//DB 연결
public class JdbcTest1 {
	
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	
	String driverName = "oracle.jdbc.driver.OracleDriver"; //드라이버명
	String url = "jdbc:oracle:thin:@localhost:1521:orcl"; 
	String user = "kitri";
	String pw = "kitri";
	
	public JdbcTest1() {
	
		try {
			//------------------------------------------------------------로드
			Class.forName(driverName);//사용할 DB를 선택(주로 생성자에서 구현)

			//------------------------------------------------------------연결
			connection = DriverManager.getConnection(url, user, pw);
			System.out.println("연결");
		} catch (ClassNotFoundException e) {
			System.out.println("[로드 오류]\n" + e.getStackTrace());
		} catch (SQLException e) {
			System.out.println("[연결 오류]\n" + e.getStackTrace());
		}
	}

	
	public void close() {
			try {
				if(connection != null)
					connection.close();
				if(statement != null)
					statement.close();
				if(resultSet != null)
					resultSet.close();
			} catch (SQLException e) {
				System.out.println("[닫기 오류]\n" + e.getStackTrace());
			}
	}
	
	public static void main(String[] args) {
		JdbcTest1 j = new JdbcTest1();
		j.close();
		
	}
}
