<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>

<title>semantic.html</title>
<style>
header{
       background-repeat: no-repeat;
       background-position: right;
       height : 100px;
}
nav>ul{list-style: none;
       padding: 0px;
}
nav>ul>li{display: inline-block;}
footer{
 position:fixed;
 bottom: 0px; 
 width: 100%;
 background-color: gray;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script>
$(function(){
	//dom트리에서 nav>ul>li>a객체들 찾기
	var aArr = $("nav>ul>li>a");
	$(aArr).click(function(){
		var vurl = $(this).attr("href");
		if(vurl == 'logout') {
			$.ajax({
				url: vurl,
				method:'get',
				success:function(result){
					$("section").html(result);
				}
			});
		} else {
			$.ajax({
				url: vurl,
				method:'get',
				success:function(result){
					$("section").html(result);
				}
			});
		}
		return false;
	});
});
</script>
</head>
<body>
<header><h1>My Web</h1></header>
<nav style="background-color: lightblue;"><div style="margin-bottom: 10px;">메뉴</div>
<jsp:include page="menu.jsp" />
</nav>
<section>본문</section>
<footer>사업자 정보 </footer>


</body>
</html>