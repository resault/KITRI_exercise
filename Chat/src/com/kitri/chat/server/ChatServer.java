package com.kitri.chat.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import com.kitri.chat.client.ChatClientController;
import com.kitri.chat.util.ChatConstance;

public class ChatServer implements Runnable {

//--------------------------------------------------------------------------------------------filed
	ServerSocket ss;
	Vector<ChatClient> list = new Vector<ChatServer.ChatClient>();
	
	
	
//--------------------------------------------------------------------------------------- constructor	
	public ChatServer() {
		//��Ʈ����
		try {
			ss = new ServerSocket(ChatConstance.PORT);
			System.out.println("Ŭ���̾�Ʈ ������ ��ٸ��� ��......");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//-------------------------------------------------------------------------------Ŭ���̾�Ʈ ����ó�� (thread)
	@Override
	public void run() {
		
		while(true) {
			try {
				Socket socket = ss.accept();
				System.out.println("Ŭ���̾�Ʈ ���� ���� :: " + socket);
				new ChatClient(socket).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

//-----------------------------------------------------------------------------------------inner Class
	class ChatClient extends Thread {
		
		String name;
		BufferedReader in; // ��... BufferedReader...??
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
		public void run() { //Thread���� ������ �۾�?!
			boolean flag = true;
			while(flag) {
				try {
					String msg = in.readLine();
					System.out.println("Ŭ���̾�Ʈ�� ���� �޼��� : " + msg);
					StringTokenizer st = new StringTokenizer(msg, "|");
					
					int protocol = Integer.parseInt(st.nextToken());
					switch(protocol) {
						case ChatConstance.CS_CONNECT : {
							name = st.nextToken();
							multicast(ChatConstance.SC_CONNECT + "|" + name);
							list.add(this);
							for(ChatClient cc : list) {
								unicast(ChatConstance.SC_CONNECT + "|" + cc.name);
							}
						} break;
						case ChatConstance.CS_ALL : {
							
						} break;
						case ChatConstance.CS_TO : {
							
						} break;
						case ChatConstance.CS_PAPER : {
							
						} break;
						case ChatConstance.CS_RENAME : {
							
						} break;
						case ChatConstance.CS_DISCONNECT : {
							multicast(ChatConstance.SC_DISCONNECT + "|" + name);
							list.remove(this);
							flag = false;
							out.close();
							in.close();
							socket.close();
						} break;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		// �ݺ����� ��� methodó��
		private void multicast(String msg){
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
//-------------------------------------------------------------------------------------inner Class ����
	
	
	
	

	public static void main(String[] args) {
		new Thread(new ChatServer()).start();
	}
}
