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
	
	        // connect() �Լ� ����
	        Chat.connect = (function(host) {
	            // ������ ���ӽõ�
	            if ('WebSocket' in window) {
	                Chat.socket = new WebSocket(host);
	            } else if ('MozWebSocket' in window) {
	                Chat.socket = new MozWebSocket(host);
	            } else {
	                Console.log('Error: WebSocket is not supported by this browser.');
	                return;
	            }
	             // ������ ������ �Ǹ� ȣ��Ǵ� �ݹ��Լ�
	            Chat.socket.onopen = function () {
	                Console.log('Info: WebSocket connection opened.');
	                // ä���Է�â�� �޽����� �Է��ϱ� ���� Ű�� ������ ȣ��Ǵ� �ݹ��Լ�
	                document.getElementById('chat').onkeydown = function(event) {
	                    // ����Ű�� ���� ���, ������ �޽����� ������
	                    if (event.keyCode == 13) {
	                        Chat.sendMessage();
	                    }
	                };
	            };
	            // ������ ������ ��쿡 ȣ��Ǵ� �ݹ��Լ�
	            Chat.socket.onclose = function () {
	            	// ä�� �Է�â �̺�Ʈ�� ������
	                document.getElementById('chat').onkeydown = null;
	                Console.log('Info: WebSocket closed.');
	            };
				
	            // �����κ��� �޽����� ���� ��쿡 ȣ��Ǵ� �ݹ��Լ�
	            Chat.socket.onmessage = function (message) {
	            	// ���ŵ� �޽����� ȭ�鿡 �����
	                Console.log(message.data); 
	            };
	        });
	     	// connect() �Լ� ���� ��
	     	
	     	
	     	
	     	
	     	// ������ ������ connect() �Լ��� ȣ���Ͽ� ������ �õ���
	        Chat.initialize = function() {
	            if (window.location.protocol == 'http:') {
	     		console.log("���� ��� �ʱ�ȭ");
	                //Chat.connect('ws://' + window.location.host + '/websocket/chat');
	            	Chat.connect('ws://localhost:80/chattest/websocket/chat');
	            } else {
	                Chat.connect('wss://' + window.location.host + '/websocket/chat');
	            }
	        };
	
	        
	        
	        
	        // ������ �޽����� �����ϰ� �Է�â���� �޽����� ������
	        Chat.sendMessage = (function() {
	            var message = document.getElementById('chat').value;
	            if (message != '') {
	                Chat.socket.send(message);
	                document.getElementById('chat').value = '';
	            }
	        });
	
	        
	        
	        
	        var Console = {}; // ȭ�鿡 �޽����� ����ϱ� ���� ��ü ����
	        // log() �Լ� ����
	        Console.log = (function(message) {
	            var console = document.getElementById('console');
	            var p = document.createElement('p');
	            p.style.wordWrap = 'break-word';
	            p.innerHTML = message;
	            console.appendChild(p); // ���޵� �޽����� �ϴܿ� �߰���
	            // �߰��� �޽����� 25���� �ʰ��ϸ� ���� ���� �߰��� �޽����� �Ѱ� ������
	            while (console.childNodes.length > 25) {
	                console.removeChild(console.firstChild);
	            }
	            // ��ũ���� �ֻ�ܿ� �ֵ��� ������
	            console.scrollTop = console.scrollHeight;
	        });
	
	        // ���� ���ǵ� �Լ�(���ӽõ�)�� ȣ����
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


