<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
- 포함지시자
<%@include file="/select.html" %><br>
<hr>
- 포함태그
<jsp:include page="/select.html"/>
</body>
</html>