<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/template/header.jsp" %>
<%
String name = request.getParameter("name");
%>
<body>
	<%=name%>님 회원가입을 환영합니다.
	<a href="<%=root%>/user/login.jsp">로그인</a>
<%@ include file="/template/footer.jsp" %>