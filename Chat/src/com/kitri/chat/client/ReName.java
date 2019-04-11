package com.kitri.chat.client;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.border.*;

public class ReName extends JFrame {
//---------------------------------------------------------------------------------------¼±¾ðºÎ
	JPanel contentPane = new JPanel();
	
	JPanel panelC = new JPanel();
	JPanel panelS = new JPanel();

	JLabel oldL = new JLabel("Old Name :");
	JLabel oldT = new JLabel("oldname");
	JLabel newL = new JLabel("New Name : ");
	JTextField newName = new JTextField();

	JButton ok = new JButton("º¯°æ");
	JButton cancel = new JButton("Ãë¼Ò");
	

	/**
	 * Create the frame.
	 */
	public ReName() {

//------------------------------------------------------------------------------------------¹èÄ¡ºÎ		

		panelC.setLayout(null);
		oldL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		oldL.setPreferredSize(new Dimension(50, 25));
		oldL.setBounds(12, 10, 79, 34);
		oldT.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		oldT.setBounds(140, 10, 72, 34);
		oldT.setPreferredSize(new Dimension(150, 15));
		newL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		newL.setPreferredSize(new Dimension(50, 25));
		newL.setBounds(12, 54, 88, 19);
		newName.setBounds(103, 49, 136, 29);
		newName.setPreferredSize(new Dimension(150, 15));
		newName.setColumns(10);
		panelC.add(oldL);
		panelC.add(oldT);
		panelC.add(newL);
		panelC.add(newName);

		ok.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		ok.setPreferredSize(new Dimension(60, 23));
		cancel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		cancel.setPreferredSize(new Dimension(60, 23));
		panelS.add(ok);
		panelS.add(cancel);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(panelC, BorderLayout.CENTER);
		contentPane.add(panelS, BorderLayout.SOUTH);

		setTitle("´ëÈ­¸í º¯°æ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 273, 171);
		setResizable(false);
		setContentPane(contentPane);
		
		
	}

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ReName frame = new ReName();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
}
