<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!//선언부
	int cnt;
	int totalLen;

	public void init() {
		cnt = 0;
		totalLen = 8;
	}%>

<%//처리부
	cnt++;
	String cntStr = cnt + "";
	int len = cntStr.length();
	int zeroLen = totalLen - len;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	당신은<br><br>
	<%
	for (int i = 0; i < zeroLen; i++)	//중괄호 없이 for문 쓸 때, 개행하면 개행줄까지만 for문 돌아버림 >> for문 밑에 한줄일지라도 중괄호 쓸것
	%><img src="/basicservlet/img/0.PNG" height="30">
	<%
	for (int i = 0; i < len; i++)
	%><img src="/basicjsp/img/<%=cntStr.charAt(i)%>.PNG" height="30">

	<br><br>번째 방문자입니다.
</body>
</html>