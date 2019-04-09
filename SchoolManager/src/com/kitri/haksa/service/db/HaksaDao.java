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
		PreparedStatement stmt = null;
		try {
			String sql = "insert into school values(?, ?, ?, ?)";
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, haksa.getName());
			stmt.setInt(2, haksa.getAge());
			stmt.setInt(3, haksa.getKey());
			stmt.setString(4, haksa.getValue());
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
		//TODO job과 join해서 keyName까지 가져올 것
		String sql = "select name , age, key_name, value from school, job where value.key = school.key and name = ?";
		PreparedStatement stmt = null;
		HaksaDto haksa = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			haksa.setName(rs.getString("name"));
			haksa.setAge((rs.getInt("s.age")));
			haksa.setKeyName(rs.getString("j.key_name"));
			haksa.setValue(rs.getString("s.value"));
			
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
				haksa.setName(rs.getString("name"));
				haksa.setAge(rs.getInt("age"));
				haksa.setValue(rs.getString("value"));
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
