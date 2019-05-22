<%@page import="com.kitri.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<c:set var="product" value="${requestScope.result}"/>
<c:set var="no" value="${product.prodNo}"/>
<script>
$(function(){
	var $bt = $(".submit button");
	$bt.click(function(){
		$.ajax({
			url : 'addcart',
			method : 'get',
			data : 'no=${no}&quantity=' + $("input[name=quantity]").val(),
			success : function(result){
				//$("section").html(result.trim());	//section내용이 clear되고 result가 추가됨
				$("div.addcartresult").remove();
				$("section").append(result.trim());	//기존 section 마지막에 result가 추가됨
			}
		});
		return false;
	});
});
</script>
<style>
</style>
<div style="float: left; margin-left: 10px;">
	<img src="img/${product.prodNo}.jpg">
</div>
<div style="float: left; c height: 300px;  margin-left: 10px;">
	<div id="prodName">${product.prodName}</div>	
	<div>${product.prodDetail}</div>
	<div>가격 : <fmt:formatNumber type="currency" currencyCode="KRW" value="${product.prodPrice}"/> </div>
	<div>상품번호 :${no}</div>	
	<div>수량 : 
		<input type="number" name="quantity" value="1" min="1" max="99">
	</div>
	<div class="submit">
		<button>장바구니 넣기</button>
	</div>
</div>






<%-- <%
Product product = (Product) request.getAttribute("result");
String no = product.getProdNo();
%>
<script>
$(function(){
	var $bt = $(".submit button");
	$bt.click(function(){
		$.ajax({
			url : 'addcart',
			method : 'get',
			data : 'no=<%=no%>&quantity=' + $("input[name=quantity]").val(),
			success : function(result){
				//$("section").html(result.trim());	//section내용이 clear되고 result가 추가됨
				$("div.addcartresult").remove();
				$("section").append(result.trim());	//기존 section 마지막에 result가 추가됨
			}
		});
		return false;
	});
});
</script>
<style>
</style>
<div style="float: left; margin-left: 10px;">
	<img src="img/<%=product.getProdNo() %>.jpg">
</div>
<div style="float: left; c height: 300px;  margin-left: 10px;">
	<div id="prodName"><%=product.getProdName() %></div>	
	<div><%=product.getProdDetail() %></div>
	<div>가격 : <%=product.getProdPrice() %></div>
	<div>상품번호 :<%=no %></div>	
	<div>수량 : 
		<input type="number" name="quantity" value="1" min="1" max="99">
	</div>
	<div class="submit">
		<button>장바구니 넣기</button>
	</div>
</div> --%>