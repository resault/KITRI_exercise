<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first.jsp</title>
</head>
<body>
첫번째 JSP입니다.
<%
int i;	//jsp가 java파일로 변환되면서, _jspService method의 지역변수로 선언됨
i=99;
%>
<%//expression : _jspService method 내부에 작성되며 out.print()가 자동호출됨 %>
<%=i %>

<%//declaration : _jspService method 외부에 작성됨 %>
<%! int i; %>


<%//expression은 _jspService method 내부에 작성되므로 지역변수 i의 값인 99가 출력됨 %>
<%=i %>
<%//전역변수 i가 호출되어 null값 출력됨 %>
<%=this.i %>


<hr>
지시자
<ul>
	<li>page directive
	<%
	Date dt = new Date();
	String pattern = "yyyy-MM-dd";
	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	%>
	<%=sdf.format(dt) %>
</ul>

</body>
</html>