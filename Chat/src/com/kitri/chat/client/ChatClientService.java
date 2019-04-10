package com.kitri.chat.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import com.kitri.chat.util.ChatConstance;

public class ChatClientService extends Thread{

	ChatClientController ccc;
	
	Socket socket;
	String myid;
	BufferedReader in;
	OutputStream out;
	
	public ChatClientService(ChatClientController chatClientControll) {

		ccc = chatClientControll;
		
	}

	/*
	 ------------------------------------------------------------------------------ 서버에 접속
	 1. ip, 대화명 get (대화명 유효성 검사)
	 2. socket 생성
	 3. IO생성
	 4. 대화명 send
	  
	 */	public void connectProcess() {
		String ip = ccc.l.ipTF.getText().trim();
		myid = ccc.l.nameTF.getText().trim();
		
		// 대화명 유효성 검사
		if(myid.length() <3) {
			JOptionPane.showMessageDialog(ccc.l, "대화명은 3자 이상입니다.", "대화명오류", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		try {
			
			//ip와 port번호로 socket 생성
			socket = new Socket(ip, ChatConstance.PORT);
			
			//IO정의
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = socket.getOutputStream();
			ccc.l.setVisible(false);
			ccc.l.chat.setVisible(true);
			
			//접속 메세지 전송
			sendMsg(ChatConstance.CS_CONNECT + "|" + myid);
			
			//Thread 실행
			new Thread(this).start();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void closeProcess() {
		sendMsg(ChatConstance.CS_DISCONNECT + "|");
	}

//------------------------------------------------------------------------서버가 보낸 메세지 처리(run override)
	@Override
	public void run() {
		boolean flag = true;
		while(flag) {
			try {
				String msg = in.readLine();
				StringTokenizer st = new StringTokenizer(msg, "|");
				int protocol = Integer.parseInt(st.nextToken());
				switch(protocol) {
					case ChatConstance.SC_CONNECT : {
						String tmp = st.nextToken();
						viewMsg("[알림] " + tmp + "님이 접속하였습니다.");
						ccc.l.chat.listData.add(tmp);
						ccc.l.chat.list.setListData(ccc.l.chat.listData);
					} break;
					case ChatConstance.SC_MESSAGE : {
						
					} break;
					case ChatConstance.SC_PAPER : {
						
					} break;
					case ChatConstance.SC_RENAME : {
						
					} break;
					case ChatConstance.SC_DISCONNECT : {
						String tmp = st.nextToken();
						if(!tmp.equals(myid)) {
							
						} else {
							out.close();
							in.close();
							socket.close();
							flag = false;
						}
					} break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

//------------------------------------------------------------------------------반복되는 기능 method 처리
	private void sendMsg(String msg) {
		try {
			out.write((msg + "\n").getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	private void viewMsg(String msg) {
		ccc.l.chat.area.append(msg + "\n");
		ccc.l.chat.area.setCaretPosition(ccc.l.chat.area.getDocument().getLength());
	}
}
