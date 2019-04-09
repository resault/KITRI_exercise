package com.kitri.chat.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import com.kitri.chat.util.ChatConstance;

public class Login extends JFrame implements ActionListener, Runnable {
	
	String myid;
	BufferedReader in;
	OutputStream out;
	
	JLabel ip;
	JLabel name;
	JTextField ipTf;
	JTextField nameTf;
	JButton cancel;
	JButton ok;
	
	Chat chat;
	Paper paper;
	Rename rename;

	public Login() {
		super("Login!!");
		initGUI();
		
		chat = new Chat();
		paper = new Paper();
		rename = new Rename();
		
//		Login창 event 등록
		nameTf.addActionListener(this);
		ok.addActionListener(this);
		cancel.addActionListener(this);
		
//		Chat창 event 등록
		chat.globalsend.addActionListener(this);
		chat.whomsend.addActionListener(this);
		chat.paper.addActionListener(this);
		chat.rename.addActionListener(this);
		chat.exit.addActionListener(this);
		
//		Paper창 event 등록
		
//		Rename창 event 등록
		
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			getContentPane().setBackground(new java.awt.Color(244,243,242));
			{
				ip = new JLabel();
				getContentPane().add(ip);
				ip.setText("\uc544\uc774\ud53c");
				ip.setBounds(12, 12, 60, 30);
				ip.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				ip.setFocusable(false);
				ip.setRequestFocusEnabled(false);
				ip.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				name = new JLabel();
				getContentPane().add(name);
				name.setText("\ub300\ud654\uba85");
				name.setBounds(12, 47, 60, 30);
				name.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				name.setFocusable(false);
				name.setRequestFocusEnabled(false);
				name.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				ipTf = new JTextField();
				getContentPane().add(ipTf);
				ipTf.setBounds(78, 12, 209, 30);
			}
			{
				nameTf = new JTextField();
				getContentPane().add(nameTf);
				nameTf.setBounds(78, 47, 209, 30);
			}
			{
				ok = new JButton();
				getContentPane().add(ok);
				ok.setText("\ub85c\uadf8\uc778");
				ok.setBounds(83, 83, 61, 32);
				ok.setBackground(new java.awt.Color(237,236,233));
				ok.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			}
			{
				cancel = new JButton();
				getContentPane().add(cancel);
				cancel.setText("\ucde8 \uc18c");
				cancel.setBounds(153, 83, 59, 32);
				cancel.setBackground(new java.awt.Color(237,236,233));
				cancel.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			}
			pack();
			this.setSize(303, 150);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Login inst = new Login();
				inst.setLocationRelativeTo(null);
				inst.setResizable(false);
				inst.setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == nameTf || ob == ok) {
			connectProcess();
		} else if(ob == cancel) {
			System.exit(0);
		} else if(ob == chat.globalsend) {
			globalsendProcess();
		} else if(ob == chat.whomsend) {
			
		} else if(ob == chat.paper) {
			
		} else if(ob == chat.rename) {
			
		} else if(ob == chat.exit) {
			
		}
	}

//	1. 메세지 get (유효성검사)
//	2. server로 메세지 전송.
	private void globalsendProcess() {
		String msg = chat.globalsend.getText().trim();
		chat.globalsend.setText("");
		if(msg.isEmpty()) {
			return;
		}
		sendMessage(ChatConstance.CS_ALL + "|" + msg);
	}

//	1. ip, 대화명 get(유효성검사(대화명 3자이상.))
//	2. 1의 ip를 이용해서 Socket생성.
//	3. IO(BufferedReader, OutputStream) 생성.
//	4. login창 닫고, chat창 열기.
//	5. server로 메세지 전송.
//	6. Thread 실행.
	private void connectProcess() {
		String ip = ipTf.getText().trim();
		myid = nameTf.getText().trim();
		if(myid.length() < 3) {
			JOptionPane.showMessageDialog(this, "대화명은 3자이상입니다.", "대화명오류", JOptionPane.WARNING_MESSAGE);
			return;
		}
		try {
			Socket socket = new Socket(ip, ChatConstance.PORT);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = socket.getOutputStream();
			this.setVisible(false);
			chat.setVisible(true);
			sendMessage(ChatConstance.CS_CONNECT + "|" + myid);
			new Thread(this).start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void sendMessage(String msg) {
		try {
			out.write((msg + "\n").getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		boolean flag = true;
		while(flag) {
			try {
				String msg = in.readLine();
				System.out.println("서버가 보낸 메세지 : " + msg);//protocol|메세지형식...
				StringTokenizer st = new StringTokenizer(msg, "|");
				int protocol = Integer.parseInt(st.nextToken());
				switch(protocol) {
					case ChatConstance.SC_CONNECT : {
//						100|접속자대화명.
						String tmp = st.nextToken();
						chat.area.append("[알림] " + tmp + "님이 접속하였습니다.\n");
						chat.area.setCaretPosition(chat.area.getDocument().getLength());
						chat.listData.add(tmp);
						chat.list.setListData(chat.listData);
					}break;
					case ChatConstance.SC_MESSAGE : {
//						200|[안효인] 안녕하세요..
						String tmp = st.nextToken();//[안효인] 안녕하세요..
						chat.area.append(tmp + "\n");
						chat.area.setCaretPosition(chat.area.getDocument().getLength());
					}break;
					case ChatConstance.SC_PAPER : {
						
					}break;
					case ChatConstance.SC_RENAME : {
						
					}break;
					case ChatConstance.SC_DISCONNECT : {
						
					}break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}















