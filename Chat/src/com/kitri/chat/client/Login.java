package com.kitri.chat.client;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.*;

public class Login extends JFrame {
	
	Chat chat;
	Paper paper;
	ReName rename;
	
	ChatClientController ccc;
	
//--------------------------------------------------------------------------------선언부	
	JPanel contentPane = new JPanel();
	JPanel panelC = new JPanel();
	
	JPanel panelCS = new JPanel();

	JLabel ipL = new JLabel("I      P :");
	JTextField ipTF = new JTextField();
	JLabel nameL = new JLabel("대화명 :");
	JTextField nameTF = new JTextField();

	JButton ok = new JButton("확인");
	JButton cancle = new JButton("취소");


	/**
	 * Create the frame.
	 */
	public Login() {
		
		chat = new Chat();
		paper = new Paper();
		rename = new ReName();
		ccc = new ChatClientController(this);
		
//-----------------------------------------------------------------------------------------배치부		
		
		panelC.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.controlShadow));
		panelC.setBackground(Color.WHITE);
		panelC.setLayout(null);
		ipL.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		ipL.setBounds(12, 14, 57, 15);
		ipTF.setBounds(69, 12, 151, 21);
		ipTF.setColumns(10);
		nameL.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		nameL.setBounds(12, 50, 57, 15);
		nameTF.setBounds(69, 48, 151, 21);
		nameTF.setColumns(10);
		panelC.add(ipL);
		panelC.add(ipTF);
		panelC.add(nameL);
		panelC.add(nameTF);
		
		panelCS.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.controlShadow));
		panelCS.setBackground(Color.WHITE);
		panelCS.setBounds(2, 84, 239, 34);
		panelC.add(panelCS);
		panelCS.setLayout(null);
		ok.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		ok.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		ok.setBounds(40, 2, 70, 28);
		cancle.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		cancle.setBounds(122, 2, 70, 28);
		panelCS.add(ok);
		panelCS.add(cancle);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(panelC, BorderLayout.CENTER);
		
		setTitle("Login!!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 269, 169);
		setContentPane(contentPane);
		
		
//------------------------------------------------------------------------------------------등록부

		//---------------------------------------- 로그인 창 이벤트 등록
		ok.addActionListener(ccc);
		cancle.addActionListener(ccc);
		nameTF.addActionListener(ccc);
		this.addWindowListener(ccc);
		
		//---------------------------------------- 채팅창 이벤트 등록
		chat.globalsend.addActionListener(ccc);
		chat.close.addActionListener(ccc);
		chat.addWindowListener(ccc);
		chat.list.addListSelectionListener(ccc);
		chat.whomsend.addActionListener(ccc);
		//---------------------------------------- 쪽지보내기창 이벤트 등록
		paper.addWindowListener(ccc);
		
		//---------------------------------------- 대화명변경창 이벤트 등록
		rename.addWindowListener(ccc);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
