package com.kitri.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//DB ����
public class JdbcTest1 {
	
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	
	String driverName = "oracle.jdbc.driver.OracleDriver"; //����̹���
	String url = "jdbc:oracle:thin:@localhost:1521:orcl"; 
	String user = "kitri";
	String pw = "kitri";
	
	public JdbcTest1() {
	
		try {
			//------------------------------------------------------------�ε�
			Class.forName(driverName);//����� DB�� ����(�ַ� �����ڿ��� ����)

			//------------------------------------------------------------����
			connection = DriverManager.getConnection(url, user, pw);
			System.out.println("����");
		} catch (ClassNotFoundException e) {
			System.out.println("[�ε� ����]\n" + e.getStackTrace());
		} catch (SQLException e) {
			System.out.println("[���� ����]\n" + e.getStackTrace());
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
				System.out.println("[�ݱ� ����]\n" + e.getStackTrace());
			}
	}
	
	public static void main(String[] args) {
		JdbcTest1 j = new JdbcTest1();
		j.close();
		
	}
}
