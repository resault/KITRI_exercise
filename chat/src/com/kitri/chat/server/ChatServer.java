package com.kitri.chat.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import com.kitri.chat.util.ChatConstance;

public class ChatServer implements Runnable {

	ServerSocket ss;
	Vector<ChatClient> list = new Vector<ChatServer.ChatClient>(); //chatserver.chatclient�� ������ �������
	
	//------------------------------------------------------------------constructor
	public ChatServer() {

		//1.��Ʈ ����
		//ServerSocket�� �ѹ��� �����Ǹ� �Ǵϱ�, ������ �ȿ��� ����
		try {
			ss = new ServerSocket(ChatConstance.PORT); //ChatConstance Ŭ������ �����ص� ����� ���ڰ�(��Ʈ��ȣ)�� �Ͽ� ����
			System.out.println("Ŭ���̾�Ʈ ���� �����...........");
		} catch (IOException e) {
			e.printStackTrace();//�� ��Ʈ��ȣ�� �̹� ������ΰ�� exception �߻���
		}
		
		
	}

	//------------------------------------------------------------------thread Ŭ���̾�Ʈ ����ó��
	@Override
	public void run() {
		while(true) {
			try {
				Socket socket = ss.accept();
				System.out.println("Ŭ���̾�Ʈ ���� ���� :: " + socket);
				new ChatClient(socket).start(); //implements�� ���� target���� ��ƾ�������, �̹����� ��������Ƿ� �ٷ� .start()
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//------------------------------------------------------------------inner Class (��ȭ��, In, Out)
	class ChatClient extends Thread {//inner Class

		String name; //��ȭ��
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
		public void run() { //�޼��� ó��
			boolean flag = true;
			while(flag) {
				try {
					//client�� ���� �޼����� ��ū������ 
					String msg = in.readLine();
					System.out.println("Ŭ���̾�Ʈ�� ���� �޼��� : " + msg);
					StringTokenizer st = new StringTokenizer(msg, "|");
					int protocol = Integer.parseInt(st.nextToken());
					switch(protocol) {
						case ChatConstance.CS_CONNECT : {
							name = st.nextToken();
//							int size = list.size();
//							for(int i=0;i<size;i++) {
//								ChatClient cc = list.get(i);
//							}
							//���� for�� - �Ʒ� ������ �� 4�ٰ� ���� ���
							for(ChatClient cc : list) { //���� "��"�� vector�� ���� �ʾ����Ƿ� "��"�� ������ ������ �������
								cc.out.write((ChatConstance.SC_CONNECT + "|" + name + "\n").getBytes()); //list�� size��ŭ for�� ���ư��鼭 out�� 
							}
							list.add(this); //Vector�� "��"��
							for(ChatClient cc : list) {
								out.write((ChatConstance.SC_CONNECT + "|" + cc.name + "\n").getBytes()); //���� �����ڵ��� �̸��� "��"���� ���� 
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
		
		//����ó�� Thread
//		ChatServer cs = new ChatServer();
//		Thread t = new Thread(cs);
//		t.start();
		new Thread(new ChatServer()).start();
		
	}
}
