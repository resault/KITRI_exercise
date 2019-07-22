<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<%@ include file="/template/header.jsp" %>
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

int cnt = 0;
try {
	conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
	StringBuffer sql = new StringBuffer();
	sql.append("insert all \n");
	sql.append("	into member (id, name, pass, emailid, emaildomain, joindate) \n");
	sql.append("	values (?, ?, ?, ?, ?, sysdate) \n");
	sql.append("	into member_detail (id, zipcode, address, address_detail, tel1, tel2, tel3) \n");
	sql.append("	values (?, ?, ?, ?, ?, ?, ?) \n");
	sql.append("select * from dual \n");
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
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(cnt != 0) {
%>

<%
} else {
%>

<%
}		
%>
<%@ include file="/template/footer.jsp" %>
</body>
</html>