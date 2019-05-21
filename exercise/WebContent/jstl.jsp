<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 

<c:set var="num" value="99"></c:set><!-- int num = 99; -->

<c:set var="num" value="${param.num }"></c:set>

<c:if test="${num%2==0 }">
짝수입니다.<br>
</c:if>

요청전달 데이터 num = ${num}<br>
<c:choose>
	<c:when test="${num%2==0 }">
		짝수입니다.<br>
	</c:when>
	<c:otherwise>
		홀수입니다.<br>
	</c:otherwise>
</c:choose>


<hr>
<c:forEach begin="1" end="10" step="1" var="i"><% for(int i=1; i<=10; i++)%>
${i}
</c:forEach>


<hr>
<c:set var="total" value="0"/>
<c:forEach begin="1" end="10" var="i">
	<c:set var="total" value="${total+1}"/>
</c:forEach>
1~10까지의 합 : ${total}

 --%>

<hr>
<%
List<String> list = new ArrayList<String>();
list.add("one");
list.add("two");
list.add("three");
request.setAttribute("list", list);
%>
<%-- <c:forEach var="e" items="${requestScope.list}">
${e}<br>
</c:forEach> --%>

<c:forEach var="e" items="${requestScope.list}" varStatus="obj">
${obj.index}번째 : ${e} : ${obj.count}회<br>
</c:forEach>




</body>
</html>