<%@page import="com.kitri.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
$(function(){
	var aArr = $("div>div>a");
	$(aArr).click(function(){
		var vurl = $(this).attr("href");
		$.ajax({
			url : vurl,
			method :'get',
			success :function(result){
				$("section").html(result);
			}
		});
		return false;
	});
});
</script>
<%
List<Product> list = (List<Product>) request.getAttribute("result");

int len = list.size();
for(int i=0;i<len;i++) {
%>
<div style="float: left; margin-left: 10px;">
<div>
	<a href="productinfo?no=<%=list.get(i).getProdNo() %>">
		<img src="img/<%=list.get(i).getProdNo() %>.jpg">
	</a>
</div>	
<div>카테고리 : <%=list.get(i).getProductCategory().getCateName() %></div>	
<div>상품번호 : <%=list.get(i).getProdNo() %></span></div>	
<div>상품명 : <%=list.get(i).getProdName() %></div>	
<div>가격 : <%=list.get(i).getProdPrice() %></div>
</div>
<%
}

%>