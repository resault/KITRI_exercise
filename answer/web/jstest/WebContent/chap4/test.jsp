<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String type = request.getHeader("User-Agent");
System.out.println(type);
if(type.contains("Android")) {
	System.out.println("안드로이드 앱으로 가라!!!");
} else if(type.contains("iPhone")) {
	System.out.println("사파리로 가라!!!");
} else {
	System.out.println("브라우저로 가라!!!");
}
%>
</body>
</html>



<![CDATA[  
오늘 "수학" 문제에서 5 < 7 이 <<참>>인지 <<거짓>>인지를 알아보는 '문제'가 나왔다.
]]>















