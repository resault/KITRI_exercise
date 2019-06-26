<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/template/header.jsp" %>
<c:if test="${userInfo != null}">
<script type="text/javascript">
$(function(){
	$('#del').click(function(){
		if(confirm("정말로 탈퇴하시겠습니까?")){
			$.ajax({
				url: $(this).attr("href"),
				method: 'post',
				success: function(result){
					if(result != 0) {
						alert("탈퇴처리가 완료되었습니다.");
						location.href="${root}/index.jsp";
					} else {
						alert("시스템 에러로 인해 작업이 완료되지 않았습니다. 나중에 다시 시도하세요.");
					}
				}
			});
		}
		return false;
	});
});
$(function(){
	$('#mod').click(function(){
		location.href=$(this).attr("href");
	});
});
</script>
<strong>${userInfo.name}(${userInfo.id})</strong>님 안녕하세요
<a href="${root}/user?act=logout">로그아웃</a>
<a href="${root}/user?act=modify" id="mod">정보수정</a>
<a href="${root}/user?act=deletemember" id="del">회원탈퇴</a>
	<c:if test="${'java2' == userInfo.id}">
		<a href="${root}/admin?act=memberlist">관리자</a>
	</c:if>
</c:if>
<c:if test="${userInfo == null}">
	<c:redirect url="/user?act=mvlogin"></c:redirect>
</c:if>
<%@ include file="/template/footer.jsp" %>