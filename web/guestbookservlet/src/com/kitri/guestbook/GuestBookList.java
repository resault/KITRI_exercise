package com.kitri.guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gblist")
public class GuestBookList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();	
		out.println("<!DOCTYPE html> \n");
		out.println("<html lang=\"ko\"> \n");
		out.println("<head> \n");
		out.println("<title>글목록</title> \n");
		out.println("<meta charset=\"utf-8\"> \n");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> \n");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\"> \n");
		out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script> \n");
		out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\"></script> \n");
		out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\"></script> \n");
		out.println("<script type=\"text/javascript\"> \n");
		out.println("function moveWrite() {");
		out.println(" document.location.href = \"/guestbookservlet/guestbook/write.html\";");
		out.println(" \n");
		out.println("} \n");
		out.println("</script> \n");
		out.println("</head> \n");
		out.println("<body> \n");
		out.println(" \n");
		out.println("<div class=\"container\" align=\"center\"> \n");
		out.println("  <div class=\"col-lg-8\" align=\"center\"> \n");
		out.println("  <h2>글목록</h2> \n");
		out.println("  <table class=\"table table-borderless\"> \n");
		out.println("  	<tr> \n");
		out.println("  		<td align=\"right\"><button type=\"button\" class=\"btn btn-link\" onclick=\"javascript:moveWrite();\">글쓰기</button></td> \n");
		out.println("  	</tr> \n");
		out.println("  </table> \n");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
			StringBuffer sql = new StringBuffer();
			sql.append("select seq, name, subject, content, logtime \n");
			sql.append("from guestbook \n");
			sql.append("order by seq desc \n");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				out.println("  <table class=\"table table-active\"> \n");
				out.println("    <tbody> \n");
				out.println("      <tr> \n");
				out.println("        <td>작성자 : " + rs.getString("name") + "</td> \n");
				out.println("        <td style=\"text-align: right;\">작성일 : " + rs.getString("logtime") + "</td> \n");
				out.println("      </tr> \n");
				out.println("      <tr> \n");
				out.println("        <td colspan=\"2\"><strong>" + rs.getString("seq") + ". " + rs.getString("subject") + "</strong></td> \n");
				out.println("      </tr> \n");
				out.println("      <tr> \n");
				out.println("        <td colspan=\"2\">" + rs.getString("content").replace("\n", "<br>") + "</td> \n");
				out.println("      </tr> \n");
				out.println("    </tbody> \n");
				out.println("  </table> \n");
			}
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
			
		out.println("  </div> \n");
		out.println("</div> \n");
		out.println(" \n");
		out.println("</body> \n");
		out.println("</html> \n");

	}
}
