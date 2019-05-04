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

@WebServlet("/register")
public class MemberRegister extends HttpServlet {
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
		int cnt = 0;
		
//		1. data get (name id pass emailid emaildomain tel1 tel2 tel3 zipcode address address_detail)
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String emailid = request.getParameter("emailid");
		String emaildomain = request.getParameter("emaildomain");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String zipcode = request.getParameter("zipcode");
		String address = request.getParameter("address");
		String addressdetail = request.getParameter("address_detail");
		
		
//		2. logic
//		insert all
//			into member (id, name, pass, emailid, emaildomain, joindate)
//			values (?, ?, ?, ?, ?, sysdate)
//			into member_detail (id, zipcode, address, address_detail, tel1, tel2, tel3)
//			values (?, ?, ?, ?, ?, ?, ?)
//		select from dual
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
			StringBuffer sql = new StringBuffer();
			sql.append("insert all\n");
			sql.append("into member (id, name, pass, emailid, emaildomain, joindate)\n");
			sql.append("values (?, ?, ?, ?, ?, sysdate)\n");
			sql.append("into member_detail (id, zipcode, address, address_detail, tel1, tel2, tel3)\n");
			sql.append("values (?, ?, ?, ?, ?, ?, ?)\n");
			sql.append("select * from dual\n");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			int idx = 0;
			pstmt.setString(++idx, id);
			pstmt.setString(++idx, name);
			pstmt.setString(++idx, pass);
			pstmt.setString(++idx, emailid);
			pstmt.setString(++idx, emaildomain);
			pstmt.setString(++idx, id);
			pstmt.setString(++idx, zipcode);
			pstmt.setString(++idx, address);
			pstmt.setString(++idx, addressdetail);
			pstmt.setString(++idx, tel1);
			pstmt.setString(++idx, tel2);
			pstmt.setString(++idx, tel3);
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
//		3. response page
//			3-1. 0! : 홍길동님 회원가입을 환영합니다.
//			3-2. 0 : 서버 문제로 회원가입에 실패하였습니다.
//		 			  다음에 다시 시도하세요.
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("	<body>");

		if(cnt != 0) {
			out.print(name + "님 가입을 환영합니다.");
			out.print("<a href=\"/memberservlet/user/login.html\">로그인</a>");
		} else {
			out.print("서버 문제로 회원가입에 실패하였습니다.<br/>");
			out.print("다음에 다시 시도하세요.");
			
		}
		out.print("	</body>");
		out.print("</html>");
	}

}
