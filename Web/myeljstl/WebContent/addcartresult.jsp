<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
$(function(){
	var arr = $("div.addcartresult>button");
	$(arr[0]).click(function(){
		$("nav>ul>li>a[href=productlist]").trigger("click");
		return false;
	});
	$(arr[1]).click(function(){
		$("nav>ul>li>a[href=viewcart]").trigger("click");
		return false;
	});
});
</script>
<div class="addcartresult" style="position:absolute; top:200px; left:100px; width: 250px; boder:1px solid; background-color: white;">
장바구니에 넣었습니다.<br><br>
<button>상품목록으로 가기</button>
<button>장바구니 보기</button>
</div>