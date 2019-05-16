<%@page import="com.kitri.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Product product = (Product) request.getAttribute("result");
%>
<style>
</style>
<div style="float: left">
	<img src="img/<%=product.getProdNo() %>.jpg">
</div>
<div style="float: left; margin-left: 10px; height: 300px">
	<div id="prodName"><%=product.getProdName() %></div>	
	<div><%=product.getProdDetail() %></div>
	<div>상품번호 : <%=product.getProdNo() %></div>	
	<div>가격 : <%=product.getProdPrice() %></div>
	<div>수량 : 
		<select name="cnt">
			<option>1</option>
			<option>2</option>
			<option>3</option>
			<option>4</option>
			<option>5</option>
		</select>
	</div>
</div>