package com.kitri.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class MaintFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btn1;
	private JButton btn2;
	
	View1 v1 = new View1();
	View2 v2 = new View2();
	
	CardLayout cl_panel = new CardLayout();
	private JPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaintFrame frame = new MaintFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MaintFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(12, 113, 477, 359);
		panel.setLayout(cl_panel);
		panel.add("view1", v1);
		panel.add("view2", v2);
		cl_panel.show(panel, "view2"); //처음에 보일 panel 지정
		contentPane.add(panel);
		
		btn1 = new JButton("\uD654\uBA741");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn1.setBounds(12, 38, 106, 51);
		contentPane.add(btn1);
		
		btn2 = new JButton("\uD654\uBA742");
		btn2.setBounds(137, 38, 106, 51);
		contentPane.add(btn2);
		
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		v1.setVisible(false);
//		v2.setVisible(false);
		Object ob = e.getSource();
		if(ob == btn1) {
			cl_panel.show(panel, "view1");//card layout의 method를 사용하면 다른 panel 안보이게 따로 설정 안해도 됨
//			v1.setVisible(true);
		} else if(ob == btn2) {
			cl_panel.show(panel, "view2");
//			v2.setVisible(true);
		}
	}


}
