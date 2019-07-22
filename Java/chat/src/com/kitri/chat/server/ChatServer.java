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
		Socket socket;
		
		public ChatClient(Socket socket) {
			try {
				this.socket = socket;
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
							//아직 "나"는 vector에 들어가지 않았으므로 "나"를 제외한 나머지 사람들임
							multicast(ChatConstance.SC_CONNECT + "|" + name); //list의 size만큼 for문 돌아가면서 out됨 
							
							list.add(this); //Vector에 "나"들어감
							for(ChatClient cc : list) {
								unicast(ChatConstance.SC_CONNECT + "|" + cc.name); //기존 접속자들의 이름을 "나"에게 보냄 
							}
						} break;
						case ChatConstance.CS_ALL : {
							String tmp = st.nextToken();
							multicast(ChatConstance.SC_MESSAGE + "|" + "[" + name + "]" + tmp); 
						}break;
						case ChatConstance.CS_TO : {
							String to = st.nextToken();
							String tmp = st.nextToken();
							for(ChatClient cc : list) {
								if(cc.name.equals(to) ) {
									cc.unicast(ChatConstance.SC_MESSAGE + "|☆" + name + "☆ "+ tmp);//그냥 unicast로 하면 귓말 보낸사람한테 감
									break;
								}
							}
						}break;
						case ChatConstance.CS_PAPER : {
							String to = st.nextToken();
							String tmp = st.nextToken();
							for(ChatClient cc : list) {
								if(cc.name.equals(to))
									cc.unicast(ChatConstance.SC_PAPER + "|" + name + "|" + tmp);
							}
								
						}break;
						case ChatConstance.CS_RENAME : {
							String newID = st.nextToken();
							multicast(ChatConstance.SC_RENAME + "|" + name + "|" + newID);
							name = newID;
						}break;
						case ChatConstance.CS_DISCONNECT : {
							multicast(ChatConstance.SC_DISCONNECT + "|" + name); //vector에 아직 "나" 있으므로, 나한테도 감
							list.remove(this);//"나"를 제거함 //이거 왜 multicast먼저 해야함??
							flag = false;//thread 종료 //여기서 break하면 case를 빠져나감
							//아래 셋 중에 하나라도 null이면 여기까지 오지도 못하니까, if문 다시 돌리지 않아도 됨
							in.close();
							out.close();
							socket.close();
						}break;
					}
				} catch (IOException e) {
					e.printStackTrace();
					break;
				}
			}
		} 
		
		private void multicast(String msg) {
			for(ChatClient cc : list) { 
				cc.unicast(msg);; 
			}
		}
		
		private void unicast(String msg) {
			try {
				out.write((msg + "\n").getBytes());
			} catch (IOException e) {
				e.printStackTrace();
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
