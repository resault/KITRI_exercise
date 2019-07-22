package com.kitri.chat.client;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.border.*;

public class Paper extends JFrame {
//-----------------------------------------------------------------------------선언부
	JPanel contentPane = new JPanel();
	
	JPanel panelN = new JPanel();
	JPanel panelS = new JPanel();

	JPanel panelN1 = new JPanel();
	JPanel panelN2 = new JPanel();

	JPanel cardP = new JPanel();

	JLabel fromL = new JLabel("From : ");
	JLabel fromT = new JLabel("from");
	JLabel toL = new JLabel("To : ");
	JLabel toT = new JLabel("to");

	JScrollPane scrollPaneA = new JScrollPane();
	JTextArea letter = new JTextArea();

	CardLayout card = new CardLayout();
	JButton send = new JButton("보내기");
	JButton answer = new JButton("답장");
	JButton cancel = new JButton("취소");


	/**
	 * Create the frame.
	 */
	public Paper() {
//-----------------------------------------------------------------------------배치부		
		fromT.setFont(new Font("굴림", Font.BOLD, 15));
		fromT.setHorizontalAlignment(SwingConstants.CENTER);
		fromT.setPreferredSize(new Dimension(60, 25));
		panelN1.add(fromL);
		panelN1.add(fromT);

		toT.setFont(new Font("굴림", Font.BOLD, 15));
		toT.setPreferredSize(new Dimension(60, 25));
		toT.setHorizontalAlignment(SwingConstants.CENTER);
		panelN2.add(toL);
		panelN2.add(toT);

		panelN.setLayout(new GridLayout(1, 2, 0, 0));
		panelN.add(panelN1);
		panelN.add(panelN2);
		
		cardP.setPreferredSize(new Dimension(70, 25));
		cardP.setLayout(card);
		cardP.setLayout(new CardLayout(0, 0));
		send.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		send.setPreferredSize(new Dimension(70, 25));
		answer.setPreferredSize(new Dimension(70, 25));
		cardP.add(send, "send");
		cardP.add(answer, "anser");

		cancel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		cancel.setPreferredSize(new Dimension(70, 25));

		panelS.add(cardP);
		panelS.add(cancel);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		scrollPaneA.setViewportView(letter);
		contentPane.add(panelN, BorderLayout.NORTH);
		contentPane.add(scrollPaneA, BorderLayout.CENTER);
		contentPane.add(panelS, BorderLayout.SOUTH);

		FlowLayout fl_panelS = (FlowLayout) panelS.getLayout();
		fl_panelS.setHgap(7);
		setTitle("쪽지보내기~~~");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 294, 327);
		setContentPane(contentPane);
		
	}

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Paper frame = new Paper();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
}
