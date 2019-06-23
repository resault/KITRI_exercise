package com.kitri.chat;


import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/websocket")
public class WebSocket {
	
	// 웹 소켓이 연결되면 호출되는 이벤트
	@OnOpen
	public void handleOpen() {
		System.out.println("Client is now connected...");
	}
	
	//웹 소켓으로부터 메시지가 오면 호출되는 이벤트
	@OnMessage
	public String handleMessage(String message) {
		System.out.println("receive from client : " + message);
		String replyMessage = "echo " + message;
		System.out.println("send to client : " + replyMessage);
		return replyMessage;
	}
	
	// 웹 소켓이 닫히면 호출되는 이벤트
	@OnClose
	public void handleClose() {
		System.out.println("client is now disconnected...");
	}
	
	// 웹 소켓이 에러나면 호출되는 이벤트
	@OnError
	public void handleError(Throwable t) {
		t.printStackTrace();
	}
	
}
