package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/counter")
public class Counter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int cnt;
	int totalLen;
	
	
	@Override
	public void init() throws ServletException {
		cnt = 0;
		totalLen = 8;
		
		try {	//drive loading은 일반적으로 생성자에서 하나, servlet에서는 일반적으로 init()에서 초기화하므로
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading !!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	public Connection makeConnection() throws SQLException {
		Connection conn;
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
		System.out.println("DB Connect Success !!!");
		return conn;
	}
	
	
	public int selNo() {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = makeConnection();
			String sql = "";
			sql += "select no \n";
			sql += "from counter";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			cnt = rs.getInt("no");
			System.out.println(cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		return cnt;
	}
	
	
	public int updateNo(int cnt) {
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = makeConnection();
			stmt = conn.createStatement();
			String sql = "";
			sql += "update counter set no=" + cnt;
			result = stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cntStr = null;
		int result = 0;
		
		cnt = selNo();
		result = updateNo(++cnt);
		System.out.println(cnt);
		if(result == 0)
			System.out.println("update fail !!!");
		
		cntStr = cnt+"";
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("	<body>");
		out.print("	당신은<br/>");
		
		int len = cntStr.length();
		int zeroLen = totalLen - len;
		
		for(int i=0;i<zeroLen;i++) {
			out.print("	<img src=\"/basicservlet/img/0.PNG\" height=\"20\">");
		}
		for(int i=0;i<len;i++) {
			out.print("	<img src=\"/basicservlet/img/" + cntStr.charAt(i) + ".PNG\" height=\"20\">");
		}
		
		out.print("<br/>번째 방문자입니다.");
		out.print("	</body>");
		out.print("</html>");
		
	}



}
