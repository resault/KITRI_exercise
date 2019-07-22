<%@page import="java.util.Set"%>
<%@page import="com.kitri.dto.Product"%>
<%@page import="java.util.Map"%>
<%@ page contentType="text/html; charset=UTF-8"%>
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
	margin: 20px;
}
div.viewcartresult>table, div.viewcartresult>table th, div.viewcartresult>table td{    
	border : 1px solid #222;
	border-collapse: collapse;
	text-align: left;
}
</style>
<script>
$(function(){
	var $bt = $("div.viewcartresult>table tr>td>button");
	$bt.click(function(){
		$.ajax({
			url:"addorder",
			method:"get",
			success:function(result){
				
			}
		});
	});
});
</script>
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
     <td><%=p.getProd_no() %></td>
     <td><%=p.getProd_name() %></td>
     <td><%=p.getProd_price() %></td>
     <td><%=rc.get(p)%></td>
   </tr>
   <%}//end for %>
   <tr><td colspan="4" style="text-align:center;"><button style="margin:10px;display:<%=session.getAttribute("loginInfo")!=null?"block":"none"%>;">주문하기</button></td></tr>
 </table>
</div>