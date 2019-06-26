package com.plzdaeng.chat.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.plzdaeng.chat.service.ChatService;
import com.plzdaeng.dto.ChatDto;
import com.plzdaeng.util.ChatMap;

//websocket 쓸때 servlet 지정하는 어노테이션
@ServerEndpoint("/chatserver")
public class ChatServer{
	//같이 채팅할 사람들을 저장하는 map
	//group_id, 해당 그룹으로 현재 채팅페이지에 들어온 사람들 명단 list
	private Map<Integer, List<Session>> chatMap;
	private ChatService service;
	
    public ChatServer() {
        super();
        service = new ChatService();
        chatMap = ChatMap.getChaMap();
    }
	
    //클라이언트가 메세지를 날릴때 호출되는 method
	@OnMessage
	public void onMessage(String msg, Session session) {
		System.out.println(msg);
		ObjectMapper mapper = new ObjectMapper();
		try {
			ChatDto chatDto = mapper.readValue(msg, ChatDto.class);
			//System.out.println(chatDto);
			
			//DB연동부분
			//아마 에러 날거라 잠시 고정값을 넣어둠
			//int result = service.insertMsg(chatDto);
			int result = 1;
			if(result == 1) {
				//정상작동
				List<Session> list = chatMap.get(chatDto.getGroup_id());
				//System.out.println(list);
				String sendMsg = mapper.writeValueAsString(chatDto);
				for(Session client : list) {
					client.getBasicRemote().sendText(sendMsg);
				}	
			} else {
				//비정상
			}
		} catch (JsonParseException e1) {
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	//클라이언트가 서버에 접속하는 순간 호출되는 method
	//서버에 접속할때 자신의 group_id 를 같이 보내줌
	//이를 기반으로 chatMap 을 구성해둠
	//DB에서 기존 대화를 다시 불러옴
	@OnOpen
	public void handleOpen(Session session) {
		System.out.println("클라이언트 입장 : " + session);
		String groupId = session.getRequestParameterMap().get("groupid").get(0);
		//System.out.println("chatmap : " + chatMap);
		List<Session> sessionList = chatMap.get(Integer.parseInt(groupId));
		//System.out.println("sessionList : " + sessionList);
		if(sessionList == null) {
			sessionList = new ArrayList<Session>();
			chatMap.put(Integer.parseInt(groupId), sessionList);
		}
		sessionList.add(session);
		
		//System.out.println("chatMap : " + chatMap);
		//System.out.println("session groupid : " + session.getQueryString());
		
		//DB연동부분 에러날거라 잠시 꺼둠
		//시작할때 기존의 대화를 불러온다
		//List<ChatDto> chatHistory = service.chatHistory(groupId);
		List<ChatDto> chatHistory = new ArrayList<ChatDto>();
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			if(chatHistory.size() == 0) {
				//System.out.println("노데이터");
				return;
			}
			String historyJSON = mapper.writeValueAsString(chatHistory);
			System.out.println(historyJSON);
			session.getBasicRemote().sendText(historyJSON);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//클라이언트 서버에서 나갈때 일반적으로 채팅페이지에서 나갈때
	//list 에서 삭제해둔다
	@OnClose
	public void handleClose(Session session) {
		System.out.println("클라이언트 퇴장 : "+session);
		String groupId = session.getRequestParameterMap().get("groupid").get(0);
		//System.out.println("그룹id : " + groupId);
		List<Session> list = chatMap.get(Integer.parseInt(groupId));
		list.remove(session);
	}
	
	
}
