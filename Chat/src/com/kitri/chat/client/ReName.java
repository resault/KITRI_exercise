package com.kitri.chat.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class ReName extends JFrame {

	private JPanel contentPane;
	private JTextField newname;
	private JPanel panel;
	private JButton ok;
	private JButton cancel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;


	/**
	 * Create the frame.
	 */
	public ReName() {
		setTitle("\uB300\uD654\uBA85 \uBCC0\uACBD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 273, 171);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		ok = new JButton("\uBCC0\uACBD");
		ok.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		ok.setPreferredSize(new Dimension(60, 23));
		panel.add(ok);
		
		cancel = new JButton("\uCDE8\uC18C");
		cancel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		cancel.setPreferredSize(new Dimension(60, 23));
		panel.add(cancel);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel("Old Name :");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		lblNewLabel.setPreferredSize(new Dimension(50, 25));
		lblNewLabel.setBounds(12, 10, 79, 34);
		panel_1.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("New Name : ");
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		lblNewLabel_2.setPreferredSize(new Dimension(50, 25));
		lblNewLabel_2.setBounds(12, 54, 88, 19);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("oldname");
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		lblNewLabel_1.setBounds(140, 10, 72, 34);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setPreferredSize(new Dimension(150, 15));
		
		newname = new JTextField();
		newname.setBounds(103, 49, 136, 29);
		panel_1.add(newname);
		newname.setPreferredSize(new Dimension(150, 15));
		newname.setColumns(10);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReName frame = new ReName();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
