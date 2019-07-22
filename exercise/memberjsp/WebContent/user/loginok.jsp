<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/template/header.jsp" %>
<%
String name = request.getParameter("name");
%>
<%=name%>님 로그인하셨습니다.
<%@ include file="/template/footer.jsp" %>