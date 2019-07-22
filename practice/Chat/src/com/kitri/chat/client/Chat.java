package com.kitri.chat.client;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.*;

public class Chat extends JFrame {
//------------------------------------------------------------------------¼±¾ðºÎ
	JPanel contentPane = new JPanel();
	JPanel panelC = new JPanel();
	JPanel panelR = new JPanel();

	JPanel panelCS = new JPanel();
	JPanel panelCS2 = new JPanel();
	JPanel panelRS = new JPanel();

	JScrollPane scrollPaneA = new JScrollPane();
	JTextArea area = new JTextArea();
	
	JTextField globalsend = new JTextField();

	JLabel whom = new JLabel("±Ó¼Ó¸»");
	JTextField whomsend = new JTextField();

	JScrollPane scrollPaneL = new JScrollPane();
	Vector<String> listData = new Vector<String>();
	JList<String> list = new JList<String>(listData);
	
	JButton rename = new JButton("´ëÈ­¸í º¯°æ");
	JButton paper = new JButton("ÂÊÁöº¸³»±â");
	JButton close = new JButton("³ª °¡ ±â");

	
	/**
	 * Create the frame.
	 */
	public Chat() {
//--------------------------------------------------------------------- ¹èÄ¡ºÎ
		panelCS2.setLayout(new BorderLayout(30, 0));
		whom.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		whomsend.setPreferredSize(new Dimension(100, 25));
		whomsend.setColumns(10);
		panelCS2.add(whom, BorderLayout.WEST);
		panelCS2.add(whomsend, BorderLayout.CENTER);

		panelCS.setLayout(new GridLayout(2, 0, 0, 3));
		globalsend.setColumns(10);
		panelCS.add(globalsend);
		panelCS.add(panelCS2);
		
		panelC.setLayout(new BorderLayout(0, 8));
		scrollPaneA.setViewportView(area);
		panelC.add(scrollPaneA, BorderLayout.CENTER);
		panelC.add(panelCS, BorderLayout.SOUTH);
		

		panelRS.setLayout(new GridLayout(3, 0, 0, 5));
		rename.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		rename.setPreferredSize(new Dimension(120, 23));
		rename.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		paper.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		paper.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		close.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		close.setPreferredSize(new Dimension(85, 25));
		close.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelRS.add(rename);
		panelRS.add(paper);
		panelRS.add(close);

		panelR.setLayout(new BorderLayout(0, 5));
		list.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPaneL.setViewportView(list);
		panelR.add(scrollPaneL, BorderLayout.CENTER);
		panelR.add(panelRS, BorderLayout.SOUTH);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(4, 0));
		contentPane.add(panelC, BorderLayout.CENTER);
		contentPane.add(panelR, BorderLayout.EAST);
		
		setTitle("Áñ°Å¿î Ã¤ÆÃ.. ^^*");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 364);
		setContentPane(contentPane);
		setResizable(false);
		
		
	}
	
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Chat frame = new Chat();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

}
