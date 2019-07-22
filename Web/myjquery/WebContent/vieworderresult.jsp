<%@page import="com.kitri.dto.Product"%>
<%@page import="com.kitri.dto.OrderLine"%>
<%@page import="java.util.Date"%>
<%@page import="com.kitri.dto.OrderInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="vieworder">
	<table border="1" style="text-align: center; width: 80%; margin: auto;">
		<h4 style="text-align:center; margin: 20px 20px 20px;">주문내역 보기</h4>
		<tr>
			<th>주문번호</th><th>주문일자</th><th>주문상품번호</th><th>상품명</th><th>가격</th><th>주문수량</th>
		</tr>
<%
List<OrderInfo> list = (List) request.getAttribute("orderlist");

for(OrderInfo info : list) {
%>
<%
	int no = info.getOrder_no(); //주문번호
	Date dt = info.getOrder_dt(); //주문일자
	List<OrderLine> lines = info.getLines();
	int len = lines.size();
%>
		<tr>
			<td rowspan="<%=len%>"><%=no %></td><td rowspan="<%=len%>"><%=dt %></td>

<%
	for(int i=0;i<len;i++) {
		OrderLine line = lines.get(i);
		Product p = line.getProduct();
		String prodNo = p.getProdNo(); //상품번호
		String prodName = p.getProdName(); //상품명
		int prodPrice = p.getProdPrice(); //가격
		int quantity = line.getOrder_quantity(); //수량
		
%>
		<%=i>0 ? "</tr><tr>" : "" %>
			<td><%=prodNo %></td><td><%=prodName %></td><td><%=prodPrice %></td><td><%=quantity %></td>
<%
	}
%>	
		</tr>
<%
}//end for
%>
	</table>
</div>