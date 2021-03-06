<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
	    <title>Apache Tomcat WebSocket Examples: Chat</title>
	    <style type="text/css">
	        input#chat {
	            width: 410px
	        }
	
	        #console-container {
	            width: 400px;
	        }
	
	        #console {
	            border: 1px solid #CCCCCC;
	            border-right-color: #999999;
	            border-bottom-color: #999999;
	            height: 170px;
	            overflow-y: scroll;
	            padding: 5px;
	            width: 100%;
	        }
	
	        #console p {
	            padding: 0;
	            margin: 0;
	        }
	    </style>
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	    <script>

	        var Chat = {};
	
	        Chat.socket = null;
	
	        // connect() 함수 정의
	        Chat.connect = (function(host) {
	            // 서버에 접속시도
	            if ('WebSocket' in window) {
	                Chat.socket = new WebSocket(host);
	            } else if ('MozWebSocket' in window) {
	                Chat.socket = new MozWebSocket(host);
	            } else {
	                Console.log('Error: WebSocket is not supported by this browser.');
	                return;
	            }
	             // 서버에 접속이 되면 호출되는 콜백함수
	            Chat.socket.onopen = function () {
	                Console.log('Info: WebSocket connection opened.');
	                // 채팅입력창에 메시지를 입력하기 위해 키를 누르면 호출되는 콜백함수
	                document.getElementById('chat').onkeydown = function(event) {
	                    // 엔터키가 눌린 경우, 서버로 메시지를 전송함
	                    if (event.keyCode == 13) {
	                        Chat.sendMessage();
	                    }
	                };
	            };
	            // 연결이 끊어진 경우에 호출되는 콜백함수
	            Chat.socket.onclose = function () {
	            	// 채팅 입력창 이벤트를 제거함
	                document.getElementById('chat').onkeydown = null;
	                Console.log('Info: WebSocket closed.');
	            };
				
	            // 서버로부터 메시지를 받은 경우에 호출되는 콜백함수
	            Chat.socket.onmessage = function (message) {
	            	// 수신된 메시지를 화면에 출력함
	                Console.log(message.data); 
	            };
	        });
	     	// connect() 함수 정의 끝
	     	
	     	
	     	
	     	
	     	// 위에서 정의한 connect() 함수를 호출하여 접속을 시도함
	        Chat.initialize = function() {
	            if (window.location.protocol == 'http:') {
	     		console.log("소켓 통신 초기화");
	                //Chat.connect('ws://' + window.location.host + '/websocket/chat');
	            	Chat.connect('ws://localhost:80/chattest/websocket/chat');
	            } else {
	                Chat.connect('wss://' + window.location.host + '/websocket/chat');
	            }
	        };
	
	        
	        
	        
	        // 서버로 메시지를 전송하고 입력창에서 메시지를 제거함
	        Chat.sendMessage = (function() {
	            var message = document.getElementById('chat').value;
	            if (message != '') {
	                Chat.socket.send(message);
	                document.getElementById('chat').value = '';
	            }
	        });
	
	        
	        
	        
	        var Console = {}; // 화면에 메시지를 출력하기 위한 객체 생성
	        // log() 함수 정의
	        Console.log = (function(message) {
	            var console = document.getElementById('console');
	            var p = document.createElement('p');
	            p.style.wordWrap = 'break-word';
	            p.innerHTML = message;
	            console.appendChild(p); // 전달된 메시지를 하단에 추가함
	            // 추가된 메시지가 25개를 초과하면 가장 먼저 추가된 메시지를 한개 삭제함
	            while (console.childNodes.length > 25) {
	                console.removeChild(console.firstChild);
	            }
	            // 스크롤을 최상단에 있도록 설정함
	            console.scrollTop = console.scrollHeight;
	        });
	
	        // 위에 정의된 함수(접속시도)를 호출함
	        //Chat.initialize();

	        
	        
	function connect() {
		Chat.initialize();
	}
	
	
	$(function(){
		$('#test').click(function(){
			location.href="${pageContext.request.contextPath}/page/chat.kitri";
		});
	});
   </script>
	</head>
	<body><p>
	<input type="button" value="Connect" onclick="javascript:connect()">
	<div>
	    <p>
	        <input type="text" placeholder="type and press enter to chat" id="chat" />
	    </p>
	    <div id="console-container">
	        <div id="console"/>
	    </div>
	</div>
	<input type="button" id="test">
	</body>
	</html>


