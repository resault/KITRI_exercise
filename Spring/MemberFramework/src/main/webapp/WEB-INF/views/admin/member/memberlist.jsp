<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<script type="text/javascript">
$(function() {	//문서가 준비되면 함수 실행하라는 의미 (window.onload와 동일)
	memberlist('', '');
	
	$("#searchBtn").click(function() {	//검색버튼을 클릭하면 호출
		var key = $("#key").val();
		var word = $("#word").val();
		$("#word").val('');
		memberlist(key, word);
	})
});

function memberlist(key, word) {
	$("#mlist").empty();
	$.ajax({
		url : "${root}/admin/memberlist.kitri", 
		type : "get",
		dataType : "json",
		data : {'key' : key, 'word' : word },
		timeout : 30000,
		cache : false,
		success : function(data){	//ajax의 callback함수  >> 성공
			var member = data.memberlist;
			var len = member.length;
						
			for(var i=0;i<len;i++) {
				var id = member[i].id;
				var name = member[i].name;
				var email = member[i].emailid + "@" + member[i].emaildomain;
				var tel = member[i].tel1 + "-" + member[i].tel2 + "-" + member[i].tel3;
				var address = member[i].zipcode + " " + member[i].address;
				var joindate = member[i].joindate;
				
				var tr = $("<tr>").attr("class", "table-active");	//체이닝
				var td1 = $("<td>").html(id);
				var td2 = $("<td>").html(name);
				var td3 = $("<td>").html(email);
				var td4 = $("<td>").html(tel);
				var td5 = $("<td>").html(address);
				var td6 = $("<td>").html(joindate);
	
				tr.append(td1).append(td2).append(td3).append(td4).append(td5).append(td6);
				$("#mlist").append(tr);
			}
		}
	});
}
</script>
<div class="table-responsive-lg">
  <h2>회원목록</h2>
  <table class="table">
  	<tr>
  		<td>
  			<form class="form-inline" action="">
			  <select class="form-control" id="key" name="key">
					<option value="id">아이디</option>
					<option value="tel3">전화번호뒷자리</option>
					<option value="address">주소</option>
				</select>
			  <input type="text" class="form-control" id="word" name="word">
			  <button type="button" class="btn btn-primary" id="searchBtn">검색</button>
			</form>
  		</td>
  	</tr>
  </table>
  <table class="table">
    <thead>
      <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>이메일</th>
        <th>전화번호</th>
        <th>주소</th>
        <th>가입일</th>
      </tr>
    </thead>
    <tbody id="mlist"></tbody>
  </table>
</div>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>