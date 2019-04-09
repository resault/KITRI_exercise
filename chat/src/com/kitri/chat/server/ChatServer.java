package com.kitri.chat.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import com.kitri.chat.util.ChatConstance;

public class ChatServer implements Runnable {

	ServerSocket ss;
	Vector<ChatClient> list = new Vector<ChatServer.ChatClient>(); //chatserver.chatclient는 지워도 상관없음
	
	//------------------------------------------------------------------constructor
	public ChatServer() {

		//1.포트 열기
		//ServerSocket은 한번만 생성되면 되니까, 생성자 안에서 생성
		try {
			ss = new ServerSocket(ChatConstance.PORT); //ChatConstance 클래스에 정의해둔 상수를 인자값(포트번호)로 하여 생성
			System.out.println("클라이언트 접속 대기중...........");
		} catch (IOException e) {
			e.printStackTrace();//위 포트번호가 이미 사용중인경우 exception 발생함
		}
		
		
	}

	//------------------------------------------------------------------thread 클라이언트 접속처리
	@Override
	public void run() {
		while(true) {
			try {
				Socket socket = ss.accept();
				System.out.println("클라이언트 접속 성공 :: " + socket);
				new ChatClient(socket).start(); //implements할 때는 target으로 잡아야하지만, 이번에는 상속했으므로 바로 .start()
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//------------------------------------------------------------------inner Class (대화명, In, Out)
	class ChatClient extends Thread {//inner Class

		String name; //대화명
		BufferedReader in; //In
		OutputStream out; //Out
		
		public ChatClient(Socket socket) {
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = socket.getOutputStream();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() { //메세지 처리
			boolean flag = true;
			while(flag) {
				try {
					//client가 보낸 메세지를 토큰단위로 
					String msg = in.readLine();
					System.out.println("클라이언트가 보낸 메세지 : " + msg);
					StringTokenizer st = new StringTokenizer(msg, "|");
					int protocol = Integer.parseInt(st.nextToken());
					switch(protocol) {
						case ChatConstance.CS_CONNECT : {
							name = st.nextToken();
//							int size = list.size();
//							for(int i=0;i<size;i++) {
//								ChatClient cc = list.get(i);
//							}
							//향상된 for문 - 아래 한줄이 위 4줄과 같은 기능
							for(ChatClient cc : list) { //아직 "나"는 vector에 들어가지 않았으므로 "나"를 제외한 나머지 사람들임
								cc.out.write((ChatConstance.SC_CONNECT + "|" + name + "\n").getBytes()); //list의 size만큼 for문 돌아가면서 out됨 
							}
							list.add(this); //Vector에 "나"들어감
							for(ChatClient cc : list) {
								out.write((ChatConstance.SC_CONNECT + "|" + cc.name + "\n").getBytes()); //기존 접속자들의 이름을 "나"에게 보냄 
							}
						} break;
						case ChatConstance.CS_ALL : {
							String tmp = st.nextToken();
							for(ChatClient cc : list) {
								cc.out.write((ChatConstance.SC_MESSAGE + "|" + "[" + name + "]" + tmp + "\n").getBytes()); 
							}
						}break;
						case ChatConstance.CS_TO : {
							
						}break;
						case ChatConstance.CS_PAPER : {
							
						}break;
						case ChatConstance.CS_RENAME : {
							
						}break;
						case ChatConstance.CS_DISCONNECT : {
							
						}break;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} 
		
		
	}
	
	
	//-------------------------------------------------------------------Main
	public static void main(String[] args) {
		
		//접속처리 Thread
//		ChatServer cs = new ChatServer();
//		Thread t = new Thread(cs);
//		t.start();
		new Thread(new ChatServer()).start();
		
	}
}
