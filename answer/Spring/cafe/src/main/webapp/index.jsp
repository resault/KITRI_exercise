<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kitri.cafe.member.model.MemberDto"%>
<%
response.sendRedirect(request.getContextPath() + "/boardadmin/boardmenu");

MemberDto memberDto = new MemberDto();
memberDto.setId("java2");
memberDto.setName("안효인");
memberDto.setEmail("java2@naver.com");

session.setAttribute("userInfo", memberDto);
%>

