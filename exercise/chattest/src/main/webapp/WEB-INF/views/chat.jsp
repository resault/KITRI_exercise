<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	var webSocket = new WebSocket('ws://localhost:80/chattest/websocket');
	var messageTextArea = $('#messageTextArea');
	var msg;
	// 웹 소켓이 연결되었을 때 호출되는 이벤트
	webSocket.onopen = function(message) {
		msg = messageTextArea.val() + 'Server Connect...\n';
		messageTextArea.val(msg);
	};
	
	// 웹 소켓이 닫혔을 때 호출되는 이벤트
	webSocket.onclose = function(message) {
		msg = messageTextArea.val() + 'Server Disconnect...\n';
		messageTextArea.val(msg);
	}
	
	// 웹 소켓 에러났을 때 호출되는 이벤트
	webSocket.onerror = function(message) {
		msg = messageTextArea.val() + 'Error...\n';
		messageTextArea.val(msg);
	}
	
	// 웹 소켓에서 메시지가 날라왔을 때 호출되는 이벤트
	webSocket.onmessage = function(message) {
		msg = messageTextArea.val() + 'Recieve From Server => ' + message.value + '\n';
		messageTextArea.val(msg);
	}
	
	// send 버튼 누르면 실행되는 함수
	function sendMessage() {
		var message = document.getElementById("textMessage");
		messageTextArea.value += "Send to Server => "+message.value+"\n";
		//웹소켓으로 textMessage객체의 값을 보낸다.
		webSocket.send(message.value);
		//textMessage객체의 값 초기화
		message.value = "";
	}
	//웹소켓 종료
	function disconnect(){
	webSocket.close();
	}
});
</script>
</head>
<body>
	<form>
	<!-- 송신 메시지 작성하는 창 -->
	<input id="textMessage" type="text">
	<!-- 송신 버튼 -->
	<input onclick="sendMessage()" value="Send" type="button">
	<!-- 종료 버튼 -->
	<input onclick="disconnect()" value="Disconnect" type="button">
	</form>
	<br />
	<!-- 결과 메시지 보여주는 창 -->
	<textarea id="messageTextArea" rows="10" cols="50"></textarea>
</body>
</html>