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
	 -----------------------------------------------------------------------------------------------------�⺻��ɺ� method
	 1. ip, ��ȭ�� get (��ȭ�� ��ȿ�� �˻�)
	 2. socket ����
	 3. IO����
	 4. ��ȭ�� send
	  
	 */	public void connectProcess() { //���� ����
		String ip = ccc.l.ipTF.getText().trim();
		myid = ccc.l.nameTF.getText().trim();
		
		// ��ȭ�� ��ȿ�� �˻�
		if(myid.length() <3) {
			JOptionPane.showMessageDialog(ccc.l, "��ȭ���� 3�� �̻��Դϴ�.", "��ȭ�����", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		try {
			
			//ip�� port��ȣ�� socket ����
			socket = new Socket(ip, ChatConstance.PORT);
			
			//IO����
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = socket.getOutputStream();
			ccc.l.setVisible(false);
			ccc.l.chat.setVisible(true);
			
			//���� �޼��� ����
			sendMsg(ChatConstance.CS_CONNECT + "|" + myid);
			
			//Thread ����
			new Thread(this).start();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void closeProcess() { // ä�ù� ������
		sendMsg(ChatConstance.CS_DISCONNECT + "|");
	}
	
	public void globalsendProcess() { //��ü ��ȭ
		String msg = ccc.l.chat.globalsend.getText().trim();
		if(msg.isEmpty())
			return;
		sendMsg(ChatConstance.CS_ALL + "|" + msg);
		ccc.l.chat.globalsend.setText("");
	}

	public void whomsendProcess() {
		String msg = ccc.l.chat.whomsend.getText().trim();
		String to = ccc.l.chat.list.getSelectedValue();
		if(msg.isEmpty())
			return;
		sendMsg(ChatConstance.CS_TO + "|" + to + "|" + msg);
		ccc.l.chat.whomsend.setText("");
	}
	
//-----------------------------------------------------������ ���� �޼��� ó��(run override)
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
						viewMsg("[�˸�] " + tmp + "���� �����Ͽ����ϴ�.");
						ccc.l.chat.listData.add(tmp);
						ccc.l.chat.list.setListData(ccc.l.chat.listData);
					} break;
					case ChatConstance.SC_MESSAGE : {
						String tmp = st.nextToken();
						viewMsg(tmp);
					} break;
					case ChatConstance.SC_PAPER : {
						
					} break;
					case ChatConstance.SC_RENAME : {
						
					} break;
					case ChatConstance.SC_DISCONNECT : {
						String tmp = st.nextToken();
						if(!tmp.equals(myid)) {
							viewMsg(tmp + "���� ������ �����Ͽ����ϴ�.");
							ccc.l.chat.listData.remove(tmp);
							ccc.l.chat.list.setListData(ccc.l.chat.listData);
						} else {
							out.close();
							in.close();
							socket.close();
							System.exit(0);
						}
					} break;
				}
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}

//------------------------------------------------------------------------------�ݺ��Ǵ� ��� method ó��
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
