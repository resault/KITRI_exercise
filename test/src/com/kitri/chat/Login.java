package com.kitri.chat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.ComponentOrientation;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class Login extends JFrame {
	private JTextField ipTF;
	private JTextField nameTF;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;


	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login!!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 269, 169);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.controlShadow));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		ipTF = new JTextField();
		ipTF.setBounds(69, 12, 151, 21);
		panel.add(ipTF);
		ipTF.setColumns(10);
		
		nameTF = new JTextField();
		nameTF.setBounds(69, 48, 151, 21);
		panel.add(nameTF);
		nameTF.setColumns(10);
		
		lblNewLabel = new JLabel("I      P :");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel.setBounds(12, 14, 57, 15);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("\uB300\uD654\uBA85 :");
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(12, 50, 57, 15);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.controlShadow));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(2, 84, 239, 34);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		btnNewButton = new JButton("\uD655 \uC778");
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnNewButton.setBounds(40, 2, 70, 28);
		panel_1.add(btnNewButton);
		
		btnNewButton_1 = new JButton("\uCDE8 \uC18C");
		btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.setBounds(122, 2, 70, 28);
		panel_1.add(btnNewButton_1);
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
