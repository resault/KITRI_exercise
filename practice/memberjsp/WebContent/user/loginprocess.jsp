<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, java.net.URLEncoder" %>
<%!
public void init() {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
%>
<%
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
String name = null;

request.setCharacterEncoding("UTF-8");

String id = request.getParameter("id");
String pass = request.getParameter("pass");

try {
	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
	
	StringBuffer sql = new StringBuffer();
	sql.append("select name \n");
	sql.append("from member \n");
	sql.append("where id = ? and pass = ? \n");
	
	pstmt = conn.prepareStatement(sql.toString());
	
	pstmt.setString(1, id);
	pstmt.setString(2, pass);
	
	rs = pstmt.executeQuery();
	
	if(rs.next()) {
		name = rs.getString("name");
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
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String root = request.getContextPath();

if(name != null) {
	response.sendRedirect(root + "/user/loginok.jsp?name=" + URLEncoder.encode(name, "UTF-8"));
} else {
	response.sendRedirect("loginfail.jsp");
}
%>
</body>
</html>