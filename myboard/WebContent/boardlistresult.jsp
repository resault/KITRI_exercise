<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
 
<script>
$(function(){
	$("tr").click(function(){
		if($(this).index() != 0){
			var board_seq = $(this).find("div.board_seq").html().trim();
			alert(board_seq+"번 글의 상세정보를 보여줍니다.");
			/* $.ajax({
				url:'boarddetail',
				method:'get',
				data:'board_seq='+board_seq,
				success:function(result){
					//~~~~
				}
			}); */
		}
		return false;
	});
	$("div.container>div.pagegroup a").click(function(){
		var currentPage=$(this).attr("href");
		$.ajax({
			url:'boardlist',
			method:'get',
			data:'currentPage='+currentPage,
			success:function(result){
				$("section").html(result.trim());
			}
		});
		return false;
	});
});
</script>   
<div class="container">
  <h3 align="center" style="margin-bottom: 30px">게시글 목록</h3>
  <div class="pageInfo" style="text-align: right;">현재페이지: ${requestScope.pb.currentPage}page, 총페이지: ${requestScope.pb.totalPage}page</div>
  <table class="table table-bordered" style="text-align:center; margin-top: 10px;">
    <tr>
      <td class="th board_seq">글번호</td>
      <td class="th board_subject">글제목</td>
      <td class="th board_writer">작성자</td>
      <td class="th board_viewcont">조회수</td>
    </tr>
<c:set var="start" value="${requestScope.startPage}"/>
<c:set var="end" value="${requestScope.endPage}"/>
<c:forEach var="board" items="${requestScope.list}">    
    <tr>
      <td class="td board_seq">${board.board_seq}</td>
      <td class="td board_subject">${board.board_subject}</td>
      <td class="td board_writer">${board.board_writer}</td>
      <td class="td board_viewcont">${board.board_viewcount}</td>
    </tr>
</c:forEach>    
  </table>
  <div class="pagegroup" style="texe-align: center"> 
      <ul>
<c:if test="${start - 1 != 0}">
       <li style="display: inline-block; margin-right: 10px;"><a href="${start - 1}" >◀</a></li>
</c:if> 
<c:forEach begin="${start}" end="${end}" var="i">
	<c:choose>
		<c:when test="${requestScope.pb.currentPage != i}">
       		<li style="display: inline-block; margin-right: 10px;"><a href="${i}">${i}</a></li>
		</c:when>
		<c:otherwise>
       		<li style="display: inline-block; margin-right: 10px;">${i}</li>
		</c:otherwise>
    </c:choose>
</c:forEach>
<c:if test="${end + 1 <= requestScope.totalPage}">
       <li style="display: inline-block; margin-right: 10px;"><a href="${end + 1}">▶</a></li>
</c:if> 
      </ul>   
  </div>   
</div>