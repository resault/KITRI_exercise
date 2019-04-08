package com.kitri.haksa.service.db;

import java.sql.*;
import java.util.ArrayList;
import com.kitri.haksa.data.db.HaksaDto;

public class HaksaDao {

	private Connection conn;
	private ResultSet rs;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "kitri";
	String pw = "kitri";
	
	// 싱글톤 
	private static HaksaDao instance = new HaksaDao();//자신의 객체를  생성
	private HaksaDao() {}
	public static HaksaDao getInstance() {//외부에서 클래스명.getInstance()를 호출하면 이 클래스의 객체가 반환됨
		return instance;
	}
	
	public void register(HaksaDto haksa) {
		String sql = "insert into school values(?, ?, ?)";
		PreparedStatement stmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, haksa.getName());
			stmt.setInt(2, haksa.getAge());
			stmt.setString(3, haksa.getValue());
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("연결 실패" + e.getStackTrace());
		} catch (ClassNotFoundException e) {
			System.out.println("로딩 실패" + e.getStackTrace());
		}finally {
				try {
					if(conn != null)
					conn.close();
					if(stmt != null)
						stmt.close();
					if(rs != null)
						rs.close();
				} catch (SQLException e) {
					System.out.println("해제 실패" + e.getStackTrace());
				}
		}
	}
	
	public HaksaDto findName(String name) {
		HaksaDto haksa = null;
		ArrayList<HaksaDto> haksaL = selecArrayList();
		int size = haksaL.size();
		for(int i = 0; i<size ; i++) {
			if(haksaL.get(i).getName().equals(name))
				haksa = haksaL.get(i);
		}
		return haksa;
		
	}
	
	public int delete(String name) {
		int result = 0;
		String sql = "delete from school where name = ?";
		PreparedStatement stmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("연결 실패" + e.getStackTrace());
		} catch (ClassNotFoundException e) {
			System.out.println("로딩 실패" + e.getStackTrace());
		}finally {
				try {
					if(conn != null)
					conn.close();
					if(stmt != null)
						stmt.close();
					if(rs != null)
						rs.close();
				} catch (SQLException e) {
					System.out.println("해제 실패" + e.getStackTrace());
				}
		}
		return result;
	}

	public ArrayList<HaksaDto> selecArrayList() {
		ArrayList<HaksaDto> haksaL = null;
		String sql = "select name, age, value from school";
		Statement stmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			haksaL = new ArrayList<HaksaDto>();
			
			while(rs.next()) {
				HaksaDto haksa = new HaksaDto();
				haksa.setName("name");
				haksa.setAge(Integer.parseInt("age"));
				haksa.setValue("value");
				haksaL.add(haksa);
			}
		} catch (SQLException e) {
			System.out.println("연결 실패" + e.getStackTrace());
		} catch (ClassNotFoundException e) {
			System.out.println("로딩 실패" + e.getStackTrace());
		}finally {
				try {
					if(conn != null)
					conn.close();
					if(stmt != null)
						stmt.close();
					if(rs != null)
						rs.close();
				} catch (SQLException e) {
					System.out.println("해제 실패" + e.getStackTrace());
				}
		}
		return haksaL;
	}
}
