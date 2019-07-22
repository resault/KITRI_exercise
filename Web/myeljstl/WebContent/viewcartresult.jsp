<%@page import="java.util.Set"%>
<%@page import="com.kitri.dto.Product"%>
<%@page import="java.util.Map"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
div.viewcartresult{
    text-align: center;
}
div.viewcartresult>h3{
    font-size: 24px;
    font-weight: bold;
    color: #222;
    
    padding-bottom: 18px;
    margin-bottom: 20px;
}
div.viewcartresult>table{
	width: 80%;
	margin: 5px;
}
div.viewcartresult>table, div.viewcartresult>table th, div.viewcartresult>table td{    
	border : 1px solid #222;
	border-collapse: collapse;
	text-align: left;
}
</style>
<script>
$(function(){
	var $btRemoveCart = $("div.viewcartresult>table tr>td>button.removecart");
	$btRemoveCart.click(function(){
		alert("장바구니비우기 클릭!");
		/* $.ajax({
			url:"removecart",
			method:"get",
			success:function(result){
				
			}
		}); */
		return false;
	});
	var $btAddOrder = $("div.viewcartresult>table tr>td>button.addorder");
	$btAddOrder.click(function(){
		$.ajax({
			url:"addorder",
			method:"get",
			success:function(result){
				if(result.trim() == "1") {	// 이거 String인데 == 비교해도 되나? ㅇㅇ
					$("nav>ul>li>a[href=vieworder]").trigger("click");
				} else {
					alert("주문실패");
				}
			}
		});
		return false;
	});
});
</script>
<%-- <div class="viewcartresult">
 <h3>장바구니 내용</h3>
<c:set var="rc" value="${requestScope.rcart}"/>
<table>
   <tr>
     <th>상품번호</th><th>상품명</th><th>상품가격</th><th>수량</th>     
   </tr>
   
<c:forEach var="e" items="${rc}">
	<c:set var="p" value="${e.key}"/>
	<c:set var="quantity" value="${e.value}"/>
   <tr>
     <td>${p.prodNo}</td>
     <td>${p.prodName}</td>
     <td>${p.prodPrice}</td>
     <td>${quantity}</td>
   </tr>
</c:forEach>
   <tr>
     <td colspan="4" style="text-align:center;">
       <button style="margin:10px;" class="removecart">장바구니 비우기</button>
<c:if test="${! empty sessionScope.loginInfo}">
       <button style="margin:10px;"class="addorder">주문하기</button>
</c:if>
     </td>
   </tr>
   
   
 </table>
</div> --%>


<div class="viewcartresult">
 <h3>장바구니 내용</h3>
<%
Map<Product,Integer> rc = (Map)request.getAttribute("rcart");
  Set<Product> keys = rc.keySet();
%>    
 <table>
   <tr>
     <th>상품번호</th><th>상품명</th><th>상품가격</th><th>수량</th>     
   </tr>
   <%   
   for(Product p:keys){ %>
   <tr>
     <td><%=p.getProdNo() %></td>
     <td><%=p.getProdName() %></td>
     <td><%=p.getProdPrice() %></td>
     <td><%=rc.get(p)%></td>
   </tr>
<%}//end for
%>    
   <tr>
     <td colspan="4" style="text-align:center;">
       <button style="margin:10px;" class="removecart">장바구니 비우기</button>
   <%if(session.getAttribute("loginInfo") != null){ //로그인한 경우만 주문하기 버튼보여주기
   %>
       <button style="margin:10px;"class="addorder">주문하기</button>
   <%}%>       
     </td>
   </tr>
   
   
 </table>
</div>