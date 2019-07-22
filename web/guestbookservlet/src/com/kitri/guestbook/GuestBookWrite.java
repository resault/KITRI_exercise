package com.kitri.guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

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
		
//		1. data get (이름, 제목, 내용)
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
//		2. Logic : 1의 data를 insert
//		insert into guestbook (seq, name, subject, content, logtime)
//		values (guestbook_seq.nextval ,?, ?, ?, sysdate)
		int cnt = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
			StringBuffer sql = new StringBuffer();
			sql.append("insert into guestbook (seq, name, subject, content, logtime) \n");
			sql.append("values (guestbook_seq.nextval ,?, ?, ?, sysdate)");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setString(++idx, name);
			pstmt.setString(++idx, subject);
			pstmt.setString(++idx, content);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
//		3. response page : 2의 결과에 따라.
//		  3-1. !0 : 글작성 성공
//		  3-2. 0 : 서버 문제로 글작성이 실패하였습니다.
//		              다음에 다시 시도하세요.
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();		
		out.println("<html>");
		out.println("	<body>");
		if(cnt != 0) {
			out.println("글작성 성공.<br>");
			out.println("<a href=\"/guestbookservlet/gblist\">글목록</a>");
		} else {
			out.println("<font size=\"10\" color=\"red\">");
			out.println("서버 문제로 글작성이 실패하였습니다.<br>");
			out.println("다음에 다시 시도하세요.");
			out.println("</font>");
			out.println("<a href=\"/guestbookservlet/guestbook/write.html\">글쓰기</a>");
		}		
		out.println("	</body>");
		out.println("</html>");
	}

}
