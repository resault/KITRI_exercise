<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>MVC 패턴을 이용한 회원가입 &amp; 로그인</h3>
		<a href="${root}/user?act=mvjoin">회원가입</a><br>
		<a href="${root}/user?act=mvlogin">로그인</a><br>
	</div>
</body>