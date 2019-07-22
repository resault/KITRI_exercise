<%@page import="com.kitri.dto.Product"%>
<%@page import="java.util.Map"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%><%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %><%
ObjectMapper mapper = new ObjectMapper();
Map<Product, Integer> rcart = (Map)request.getAttribute("rcart");

String result = mapper.writeValueAsString(rcart);
%><%=result%>