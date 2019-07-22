package com.kitri.guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/gbwrite")
public class GuestBookWrite extends HttpServlet {
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
		
//		1. data get (name, subject, content)
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		
//		2. logic
//		insert into guestbook
//		values (guestbook_seq.nextval, ?, ?, ?, sysdate)
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
			StringBuffer sql = new StringBuffer();
			sql.append("insert into guestbook \n");
			sql.append("values (guestbook_seq.nextval, ?, ?, ?, sysdate) \n");
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, name);
			pstmt.setString(2, subject);
			pstmt.setString(3, content);
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
//		3. response page
//			3-1. != 0 : 글 작성이 완료되었습니다.
//			3-2. 0 : 서버 문제로 글 저장에 실패하였습니다.
//		 			  다음에 다시 시도하세요.
		
		response.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = response.getWriter();
		
		
		out.print("<html>");
		out.print("	<body>");
		
		if(cnt != 0) {
			out.print("글 작성이 완료되었습니다.");
			out.print("<a href=\"/guestbookservlet/gblist\">글목록</a>");
		} else {
			out.print("서버 문제로 글 저장에 실패하였습니다. 다음에 다시 시도하세요.");
		}
		
		out.print("	</body>");
		out.print("</html>");
		
		
	}

}
