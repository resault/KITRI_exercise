package com.kitri.chat.client;

import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.kitri.chat.util.ChatConstance;

public class Login extends JFrame implements ActionListener, Runnable, ListSelectionListener {
	
	Socket socket;
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
		
		//----------------------------------login창 event 등록
		nameTf.addActionListener(this);
		ok.addActionListener(this);
		cancel.addActionListener(this);
		
		//----------------------------------chat창 event 등록
		chat.globalsend.addActionListener(this);
		chat.whomsend.addActionListener(this);
		chat.paper.addActionListener(this);
		chat.rename.addActionListener(this);
		chat.exit.addActionListener(this);
		chat.list.addListSelectionListener(this);
		chat.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				closeProcess();
			}
		}); 
		
		//----------------------------------paper창 event 등록
		
		paper.ok.addActionListener(this);
		paper.cancel.addActionListener(this);
		paper.answer.addActionListener(this);
		
		//----------------------------------rename창 event 등록
		rename.ok.addActionListener(this);
		rename.cancel.addActionListener(this);
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
			System.exit(0); //이 시점에서는 네트워크와 관련된 것이 없으므로 그냥 프로그램 종료 시키면 됨
		} else if(ob == chat.globalsend) {
			globalsendProcess();
		} else if(ob == chat.whomsend) {
			whomsendProcess();
		} else if(ob == chat.paper) {
			paper();
		} else if(ob == paper.ok) {
			paperProcess();
		} else if(ob == paper.answer) {
			paper.card.show(paper.cardp, "ok");
			paper.to.setText(paper.from.getText());
			paper.from.setText(myid);
			paper.letter.append("\n------------------ 원문 -------------------\n");
		} else if(ob == paper.cancel) {
			paper.setVisible(false);
		} else if(ob == chat.rename) {
			rename.oldname.setText(myid);
			rename.setVisible(true);
		} else if(ob == chat.exit) {
			closeProcess();
		} else if(ob == rename.ok) {
			renameProcess();
		} else if(ob == rename.cancel) {
			rename.setVisible(false);
		}
			
			
	}



	@Override
	public void valueChanged(ListSelectionEvent e) {
		String selName = chat.list.getSelectedValue();
		chat.whom.setText(selName);
	}

	/*
	 1. 메세지 get (유효성검사)
	 2. server로 메세지 전송
	 */
	private void globalsendProcess() {
		String msg = chat.globalsend.getText().trim();
		chat.globalsend.setText("");
		if(msg.isEmpty())
			return;
		sendMessage(ChatConstance.CS_ALL + "|" + msg);
	}

	/*
	 1. 대상자, 메세지 get (유효성검사 대상자, 자신, 메세지)
	 2. server로 메세지 전송
	 */
	private void whomsendProcess() {
		String msg = chat.whomsend.getText().trim();
		chat.whomsend.setText("");
		if(msg.isEmpty())
			return;
		
		String to = chat.whom.getText();
		if(to.isEmpty()) {
			JOptionPane.showMessageDialog(chat, "대상자를 선택하세요", "대상자오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(to.equals(myid)) {
			JOptionPane.showMessageDialog(chat, "자신에게 귓속말을??", "대상자오류", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		sendMessage(ChatConstance.CS_TO + "|" + to + "|" + msg);
		viewMessage("★" + to + "★" + msg);
	}
	
	
	private void paper() {
		String to = chat.whom.getText();
		if(to.isEmpty()) {
			JOptionPane.showMessageDialog(chat, "대상자를 선택하세요", "대상자오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(to.equals(myid)) {
			JOptionPane.showMessageDialog(chat, "자신에게 쪽지를??", "대상자오류", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		chat.whom.setText("");
		paper.card.show(paper.cardp, "ok");
		paper.from.setText(myid);
		paper.to.setText(to);
		paper.letter.setText("");
		paper.setVisible(true);
	}
	
	private void paperProcess() {
		String msg = paper.letter.getText().trim();
		String to = paper.to.getText().trim();
		if(msg.length()==0) {
			JOptionPane.showMessageDialog(chat, "내용을 입력하세요", "내용오류", JOptionPane.ERROR_MESSAGE);
		}
		msg = msg.replace("\n", "***");
		sendMessage(ChatConstance.CS_PAPER + "|" + to + "|" + msg);
		paper.letter.setText("");
		paper.to.setText("");
		paper.setVisible(false);
	}
	
	private void renameProcess() {
		String newID = rename.newname.getText().trim();
		if(newID.isEmpty()) {
			JOptionPane.showMessageDialog(chat, "대화명을 입력하세요", "대화명오류", JOptionPane.ERROR_MESSAGE);
		}
		myid = newID; 
		sendMessage(ChatConstance.CS_RENAME + "|" + newID);
		rename.newname.setText("");
		rename.setVisible(false);
	}

	private void closeProcess() {
		sendMessage(ChatConstance.CS_DISCONNECT + "|");
	}


	/*
	 - connectProcess()기능
	 1. ip, 대화명 get(유효성 검사: 대화명 3자이상)
	 2. 1의 ip를 이용해서 Socket 생성
	 3. IO(BufferedReader, OutputStream) 생성
	 4. login창 닫고, chat창 열기
	 5. server로 메세지 전송
	 6. Thread 실행
	 */	
	private void connectProcess() {
		//ip와 대화명 정의
		String ip = ipTf.getText().trim();
		myid = nameTf.getText().trim();
		
		//대화명 유효성 검사
		
		if(myid.length() < 3) {
			JOptionPane.showMessageDialog(this, "대화명은 3자이상입니다.", "대화명오류", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		try {
			//ip와 port번호로 socket 생성
			socket = new Socket(ip, ChatConstance.PORT);
			
			//IO 정의
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = socket.getOutputStream();
			this.setVisible(false);
			chat.setVisible(true);
			
			//접속 메세지 전송
			sendMessage(ChatConstance.CS_CONNECT + "|" + myid); //서버에서는 BufferedReader로 읽기 때문에 반드시 엔터를 같이 보내야 함
			
			//Thread 실행
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
	

	private void viewMessage(String msg) {
		chat.area.append(msg + "\n");
		chat.area.setCaretPosition(chat.area.getDocument().getLength());
	}

	
	@Override
	public void run() {//메세지 처리
		boolean flag = true;
		while(flag) {
			try {
				//server가 보낸 메세지를 토큰단위로 
				String msg = in.readLine();
				System.out.println("서버가 보낸 메세지 : " + msg);
				StringTokenizer st = new StringTokenizer(msg, "|");
				int protocol = Integer.parseInt(st.nextToken());
				switch(protocol) {
					case ChatConstance.SC_CONNECT : {
						String tmp = st.nextToken();
						viewMessage("[알림] " + tmp + "님이 접속하였습니다.");
						chat.listData.add(tmp);
						chat.list.setListData(chat.listData);//list에 변경된 vector를 적용
					} break;
					case ChatConstance.SC_MESSAGE : {
						String tmp = st.nextToken();
						viewMessage(tmp);
					}break;
					case ChatConstance.SC_PAPER : {
						String from = st.nextToken();
						String tmp = st.nextToken();
						tmp = tmp.replace("***", "\n");
						paper.from.setText(from);
						paper.to.setText(myid);
						paper.letter.setText(tmp);
						paper.card.show(paper.cardp, "answer");
						paper.letter.setCaretPosition(paper.letter.getDocument().getLength());
						paper.setVisible(true);
					}break;
					case ChatConstance.SC_RENAME : {
						String oldid = st.nextToken();
						String newid = st.nextToken();
						viewMessage("[알림] " +oldid + "님의 대화명이 " + newid + "로 변경되었습니다.");
						int i = chat.listData.indexOf(oldid);
						chat.listData.set(i, newid);
						chat.list.setListData(chat.listData);
					}break;
					case ChatConstance.SC_DISCONNECT : {
						String tmp = st.nextToken();
						if(!tmp.equals(myid)) {
							viewMessage("[알림] " + tmp + "님이 접속을 종료하였습니다.");
							chat.listData.remove(tmp);
							chat.list.setListData(chat.listData);
						} else {
							flag = false; //아래서 exit하기 때문에 사실상 의미 없음
							in.close();
							out.close();
							socket.close();
							System.exit(0);//but, 일반적으로는 강제종료하는 것 보다는 자연종료 시키는게 나음
						}
					}break;
				}
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}
	

}
