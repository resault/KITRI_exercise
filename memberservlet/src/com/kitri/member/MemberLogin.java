package com.kitri.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String name = null;
		
//		1. data get (아이디, 비번)
		request.setCharacterEncoding("UTF-8");	//한글 안 쓸거면 굳이 안해도 됨
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
//		2. Logic : 1의 아이디를 조건으로 비번 select하여 비번과 비교
//		select name
//		from member
//		where id=? and pass=?
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
			StringBuffer sql = new StringBuffer();
		
			sql.append("select name\n");
			sql.append("from member\n");
			sql.append("where id=? and pass=?\n");
			
			pstmt = conn.prepareCall(sql.toString());
			
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
				name = rs.getString("name");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		
		
//		3. response page : 2의 결과에 따라
//			3-1. name != null : 홍길동님 안녕하세요
//			3-2. name == null : 등록되지 않은 아이디이거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다.
//								로그인(링크)
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		
		if(name != null) {
			out.println("<strong>" + name + "</strong>님 안녕하세요");
		} else {
			out.println("<font size=\"11\" color=\"red\">");
			out.println("등록되지 않은 아이디이거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다.<br/>");
			out.println("</font>");
			out.println("<a href=\"/memberservlet/user/login.html\">로그인</a>");
		}
		
		out.println("	</body>");
		out.println("</html>");
		
		
	}

}
