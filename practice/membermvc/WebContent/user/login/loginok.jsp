<%@page import="com.kitri.member.util.MoveUrl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kitri.member.model.MemberDto" %>
<%@ include file="/template/header.jsp" %>
<%
String name = request.getParameter("name");
MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
if(memberDto != null){
%>
<script type="text/javascript">
function deleteMember(){
	if(confirm("정말로 탈퇴??")) {
	}
}
</script>
<strong><%=memberDto.getName()%>(<%=memberDto.getId()%>)</strong>님 안녕하세요
<a href="<%=root%>/user?act=logout">로그아웃</a>
<a href="<%=root%>/user?act=modify">정보수정</a>
<a href="#" onclick="javascript:deleteMember();">회원탈퇴</a>
<%
	if("mvctest".equals(memberDto.getId())){
%>
		<a href="<%=root%>/admin?act=memberlist">관리자</a>
<%
	}
} else {
	MoveUrl.redirect(request, response, "/user?act=mvlogin");
}
%>
<%@ include file="/template/footer.jsp" %>