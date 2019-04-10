package com.kitri.chat.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import com.kitri.chat.util.ChatConstance;

public class ChatServer implements Runnable {

	ServerSocket ss;
	Vector<ChatClient> list = new Vector<ChatServer.ChatClient>();
	
	public ChatServer() {
		try {
			ss = new ServerSocket(ChatConstance.PORT);
			System.out.println("클라이언트 접속 대기중.........");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {//접속처리..
		while(true) {
			try {
				Socket socket = ss.accept();
				System.out.println("클라이언트 접속 성공 :: " + socket);
				new ChatClient(socket).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	class ChatClient extends Thread {
		
		String name;
		BufferedReader in;
		OutputStream out;
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
		public void run() {//메세지처리..
			boolean flag = true;
			while(flag) {
				try {
					String msg = in.readLine();
					System.out.println("클라이언트가 보낸 메세지 : " + msg);//protocol|메세지형식...
					StringTokenizer st = new StringTokenizer(msg, "|");
					int protocol = Integer.parseInt(st.nextToken());
					switch(protocol) {
						case ChatConstance.CS_CONNECT : {
//							100|안효인
							name = st.nextToken();//안효인
//							int size = list.size();
//							for(int i=0;i<size;i++) {
//								ChatClient cc = list.get(i);
//							}
							multicast(ChatConstance.SC_CONNECT + "|" + name);

							list.add(this);
							for(ChatClient cc : list) {
								unicast(ChatConstance.SC_CONNECT + "|" + cc.name);
							}
						}break;
						case ChatConstance.CS_ALL : {
//							200|안녕하세요.
							String tmp = st.nextToken();//안녕하세요.
							multicast(ChatConstance.SC_MESSAGE + "|[" + name + "] " + tmp);
						}break;
						case ChatConstance.CS_TO : {
//							250|홍길동|안녕???
							String to = st.nextToken();//홍길동
							String tmp = st.nextToken();//안녕???
							for(ChatClient cc : list) {
								if(cc.name.equals(to)) {
									cc.unicast(ChatConstance.SC_MESSAGE + "|☆" + name + "☆ " + tmp);
									break;
								}
							}
						}break;
						case ChatConstance.CS_PAPER : {
							
						}break;
						case ChatConstance.CS_RENAME : {
							
						}break;
						case ChatConstance.CS_DISCONNECT : {
//							900|
							multicast(ChatConstance.SC_DISCONNECT + "|" + name);
							list.remove(this);
							flag = false;
							in.close();
							out.close();
							socket.close();
						}break;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		private void multicast(String msg) {
			for(ChatClient cc : list) {
				cc.unicast(msg);
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
	
	public static void main(String[] args) {
//		ChatServer cs = new ChatServer();
//		Thread t = new Thread(cs);
//		t.start();
		new Thread(new ChatServer()).start();
	}
	
}



















