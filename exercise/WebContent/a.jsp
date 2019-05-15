<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); //request의 body content의 인코딩을 바꿔줌! >>> body content를 사용하지 않는 get방식과는 무관함 %>
<%
String id = request.getParameter("id");
String name = request.getParameter("name");
%>
<%
Thread.sleep(1*1000);	//응답시간을 지연시킴 >>> ajax로 요청할 경우 응답이 도착하기 전까지 웹브라우저가 다른 작업을 할 것임
%><%=name%>(<%=id%>)님 반갑습니다.