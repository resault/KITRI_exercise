package com.kitri.haksa.service.db;

import java.sql.*;
import java.util.ArrayList;
import com.kitri.haksa.data.db.HaksaDto;

public class HaksaDao {

	Connection connection;
	Statement statement;
	ResultSet resultSet;
	
	String driverName = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "kitri";
	String pw = "kitri";
	
	public HaksaDao() {
		try {
			//-------------------------------------------�ε�
			Class.forName(driverName);
			//-------------------------------------------����
			connection = DriverManager.getConnection(url, user, pw);
			
		} catch (ClassNotFoundException e) {
			System.out.println("[�ε� ����]\n" + e.getStackTrace());
		} catch (SQLException e) {
			System.out.println("[���� ����]\n" + e.getStackTrace());
		}		
	}
	
	public void register(HaksaDto haksa) {
		String register = "";
	}
	
	public HaksaDto findName(String name) {
		
		
		return null;
	}
	
	public int delete(String name) {
		
		return 0;
	}

	public ArrayList<HaksaDto> selecArrayList() {
		
		return null;
	}
}
