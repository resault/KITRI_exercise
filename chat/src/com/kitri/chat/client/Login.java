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
		
		//----------------------------------loginâ event ���
		nameTf.addActionListener(this);
		ok.addActionListener(this);
		cancel.addActionListener(this);
		
		//----------------------------------chatâ event ���
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
		
		//----------------------------------paperâ event ���
		
		paper.ok.addActionListener(this);
		paper.cancel.addActionListener(this);
		paper.answer.addActionListener(this);
		
		//----------------------------------renameâ event ���
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
			System.exit(0); //�� ���������� ��Ʈ��ũ�� ���õ� ���� �����Ƿ� �׳� ���α׷� ���� ��Ű�� ��
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
			paper.letter.append("\n------------------ ���� -------------------\n");
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
	 1. �޼��� get (��ȿ���˻�)
	 2. server�� �޼��� ����
	 */
	private void globalsendProcess() {
		String msg = chat.globalsend.getText().trim();
		chat.globalsend.setText("");
		if(msg.isEmpty())
			return;
		sendMessage(ChatConstance.CS_ALL + "|" + msg);
	}

	/*
	 1. �����, �޼��� get (��ȿ���˻� �����, �ڽ�, �޼���)
	 2. server�� �޼��� ����
	 */
	private void whomsendProcess() {
		String msg = chat.whomsend.getText().trim();
		chat.whomsend.setText("");
		if(msg.isEmpty())
			return;
		
		String to = chat.whom.getText();
		if(to.isEmpty()) {
			JOptionPane.showMessageDialog(chat, "����ڸ� �����ϼ���", "����ڿ���", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(to.equals(myid)) {
			JOptionPane.showMessageDialog(chat, "�ڽſ��� �ӼӸ���??", "����ڿ���", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		sendMessage(ChatConstance.CS_TO + "|" + to + "|" + msg);
		viewMessage("��" + to + "��" + msg);
	}
	
	
	private void paper() {
		String to = chat.whom.getText();
		if(to.isEmpty()) {
			JOptionPane.showMessageDialog(chat, "����ڸ� �����ϼ���", "����ڿ���", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(to.equals(myid)) {
			JOptionPane.showMessageDialog(chat, "�ڽſ��� ������??", "����ڿ���", JOptionPane.INFORMATION_MESSAGE);
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
			JOptionPane.showMessageDialog(chat, "������ �Է��ϼ���", "�������", JOptionPane.ERROR_MESSAGE);
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
			JOptionPane.showMessageDialog(chat, "��ȭ���� �Է��ϼ���", "��ȭ�����", JOptionPane.ERROR_MESSAGE);
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
	 - connectProcess()���
	 1. ip, ��ȭ�� get(��ȿ�� �˻�: ��ȭ�� 3���̻�)
	 2. 1�� ip�� �̿��ؼ� Socket ����
	 3. IO(BufferedReader, OutputStream) ����
	 4. loginâ �ݰ�, chatâ ����
	 5. server�� �޼��� ����
	 6. Thread ����
	 */	
	private void connectProcess() {
		//ip�� ��ȭ�� ����
		String ip = ipTf.getText().trim();
		myid = nameTf.getText().trim();
		
		//��ȭ�� ��ȿ�� �˻�
		
		if(myid.length() < 3) {
			JOptionPane.showMessageDialog(this, "��ȭ���� 3���̻��Դϴ�.", "��ȭ�����", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		try {
			//ip�� port��ȣ�� socket ����
			socket = new Socket(ip, ChatConstance.PORT);
			
			//IO ����
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = socket.getOutputStream();
			this.setVisible(false);
			chat.setVisible(true);
			
			//���� �޼��� ����
			sendMessage(ChatConstance.CS_CONNECT + "|" + myid); //���������� BufferedReader�� �б� ������ �ݵ�� ���͸� ���� ������ ��
			
			//Thread ����
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
	public void run() {//�޼��� ó��
		boolean flag = true;
		while(flag) {
			try {
				//server�� ���� �޼����� ��ū������ 
				String msg = in.readLine();
				System.out.println("������ ���� �޼��� : " + msg);
				StringTokenizer st = new StringTokenizer(msg, "|");
				int protocol = Integer.parseInt(st.nextToken());
				switch(protocol) {
					case ChatConstance.SC_CONNECT : {
						String tmp = st.nextToken();
						viewMessage("[�˸�] " + tmp + "���� �����Ͽ����ϴ�.");
						chat.listData.add(tmp);
						chat.list.setListData(chat.listData);//list�� ����� vector�� ����
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
						viewMessage("[�˸�] " +oldid + "���� ��ȭ���� " + newid + "�� ����Ǿ����ϴ�.");
						int i = chat.listData.indexOf(oldid);
						chat.listData.set(i, newid);
						chat.list.setListData(chat.listData);
					}break;
					case ChatConstance.SC_DISCONNECT : {
						String tmp = st.nextToken();
						if(!tmp.equals(myid)) {
							viewMessage("[�˸�] " + tmp + "���� ������ �����Ͽ����ϴ�.");
							chat.listData.remove(tmp);
							chat.list.setListData(chat.listData);
						} else {
							flag = false; //�Ʒ��� exit�ϱ� ������ ��ǻ� �ǹ� ����
							in.close();
							out.close();
							socket.close();
							System.exit(0);//but, �Ϲ������δ� ���������ϴ� �� ���ٴ� �ڿ����� ��Ű�°� ����
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
