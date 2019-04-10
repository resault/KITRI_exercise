package com.kitri.chat.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class Chat extends JFrame {

	private JPanel contentPane = new JPanel();
	
	private JPanel panelC = new JPanel();
	private JPanel panelR = new JPanel();

	private JScrollPane scrollPaneA = new JScrollPane();
	private JTextArea area = new JTextArea();
	
	private JPanel panelCS = new JPanel();
	private JTextField globalsend = new JTextField();

	private JPanel panelCS2 = new JPanel();
	private JLabel whom = new JLabel("±Ó¼Ó¸»");
	private JTextField whomsend = new JTextField();

	private JScrollPane scrollPaneL = new JScrollPane();
	private JTextArea list = new JTextArea();
	
	private JPanel panelRS = new JPanel();
	private JButton rename = new JButton("´ëÈ­¸í º¯°æ");
	private JButton paper = new JButton("ÂÊÁöº¸³»±â");
	private JButton close = new JButton("³ª °¡ ±â");

	
	/**
	 * Create the frame.
	 */
	public Chat() {

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
		
		

		
		panelR.setLayout(new BorderLayout(0, 5));

		
		panelR.add(panelRS, BorderLayout.SOUTH);
		panelRS.setLayout(new GridLayout(3, 0, 0, 5));

		panelRS.add(rename);
		
		rename.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		rename.setPreferredSize(new Dimension(120, 23));
		rename.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));

		
		paper.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		paper.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelRS.add(paper);

		
		close.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		close.setPreferredSize(new Dimension(85, 25));
		close.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelRS.add(close);
		
		
		panelR.add(scrollPaneL, BorderLayout.CENTER);
		
		
		list.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPaneL.setViewportView(list);

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
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat frame = new Chat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
