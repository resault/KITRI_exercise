<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>
<%@attribute name="current" required="true" type="java.lang.Integer"%>		<!-- type에는 기본형X -->
<%@attribute name="start" required="false" type="java.lang.Integer"%>
<%@attribute name="end" required="false" type="java.lang.Integer"%>
<%@attribute name="url" required="false"%>
<%
for(int i=start; i<=end; i++){
	if(i != current){
%>
<a href="<%=url%>?page=<%=i%>"><%=i%></a>		
<%
	}else {
%>
<%=i%>
<%
	}
}
%>