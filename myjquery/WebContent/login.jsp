<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	//dom에서 form객체찾기
	$("#form").submit(function(){
		$ajax({
			url : 'loginprocess.jsp',
			method : 'post',
			data : 'id='+$('input[name=id]').val()+'&pwd='+$('input[name=pwd]').val(),
			//객체로 전달하는 방법
//			{id:$('input[name=id]').val(),
//			pwd:$('input[name=pwd]').val()
//			},
			//serialize() 사용하는 방법
//			$('form').serialize(),

			success:function(result){
				$("section").html(result);				
			}
			
		});
		return false;
	});
	
});
$(document).ready(function() {

});
function login() {
	if(document.getElementById("id").value == "") {
		alert("아이디를 입력하세요!!!")
	} else if(document.getElementById("pass").value == "") {
		alert("비밀번호를 입력하세요!!!")
	} else {
		document.getElementById("loginform").action = "/memberservlet/login";
		document.getElementById("loginform").submit();
	}
}
</script>
<form id="loginform" method="post" action="">
	<div class="form-group" align="left">
		<label for="">ID</label>
		<input type="text" class="form-control" id="id" name="id" placeholder="">
	</div>
	<div class="form-group" align="left">
		<label for="">PASS</label>
		<input type="password" class="form-control" id="pass" name="pass" placeholder="">
	</div>
	<div class="form-group" align="center">
		<button type="button" class="btn btn-warning" id="loginBtn" onclick="javascript:login();">LOGIN</button>
		<button type="button" class="btn btn-primary" id="moveRegisterBtn">JOIN MEMBER</button>
	</div>
</form>
