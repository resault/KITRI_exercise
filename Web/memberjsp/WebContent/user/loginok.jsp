<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/template/header.jsp" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String name = request.getParameter("name");
%>
	<strong><%=name%></strong>님 안녕하세요
<%@ include file="/template/footer.jsp" %>