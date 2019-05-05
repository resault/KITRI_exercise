package com.kitri.guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gblist")
public class GuestBookList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GuestBookDto> list = new ArrayList<GuestBookDto>();
		
//		1. 받을 데이터 없음
		
		
//		2. logic : db에서 글 목록 select
//		select seq, name, subject, content, logtime
//		from guestbook
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
			StringBuffer sql = new StringBuffer();
			sql.append("select seq, name, subject, content, to_char(logtime, 'yyyy.mm.dd') logtime \n");
			sql.append("from guestbook \n");
			sql.append("order by seq \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GuestBookDto gb = new GuestBookDto();
				
				gb.setSeq(rs.getInt("seq"));
				gb.setName(rs.getString("name"));
				gb.setSubject(rs.getString("subject"));
				gb.setContent(rs.getString("content"));
				gb.setLogtime(rs.getString("logtime"));
				
				list.add(gb);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
//		3. response page
		
		response.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = response.getWriter();
		
		
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>글목록</title>");
		out.print("<meta charset=\"utf-8\">");
		out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.print("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\">");
		out.print("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
		out.print("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\"></script>");
		out.print("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\"></script>");
		out.print("<script type=\"text/javascript\">");

		out.print("</script>");
		out.print("</head>");
		out.print("<body>");

		out.print("<div class=\"container\" align=\"center\">");
		out.print("  <div class=\"col-lg-8\" align=\"center\">");
		out.print("  <h2>글목록</h2>");
		out.print("  <table class=\"table table-borderless\">");
		out.print("  	<tr>");
		out.print("  		<td align=\"right\"><button type=\"button\" class=\"btn btn-link\" onclick=\"location.href='/guestbookservlet/guestbook/write.html'\">글쓰기</button></td>");
		out.print("  	</tr>");
		out.print("  </table>");
		
		int len = list.size();
		for(int i=0;i<len;i++) {
			out.print("  <table class=\"table table-active\">");
			out.print("    <tbody>");
			out.print("      <tr>");
			out.print("        <td>작성자 : " + list.get(i).getName() + "</td>");
			out.print("        <td style=\"text-align: right;\">작성일 : " + list.get(i).getLogtime() + "</td>");
			out.print("      </tr>");
			out.print("      <tr>");
			out.print("        <td colspan=\"2\"><strong>" + list.get(i).getSeq() + ". " + list.get(i).getSubject() + "</strong></td>");
			out.print("      </tr>");
			out.print("      <tr>");
			out.print("        <td colspan=\"2\">" + list.get(i).getContent() + "</td>");
			out.print("      </tr>");
			out.print("    </tbody>");
			out.print("  </table>");
		}
		
		out.print("  </div>");
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");

		
	}

}
