package com.kitri.chat;

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

	private JPanel contentPane;
	private JTextField globalsend;
	private JLabel whom;
	private JTextField whomsend;
	private JButton rename;
	private JButton paper;
	private JButton close;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_1;
	private JPanel panel_4;
	private JScrollPane scrollPane;
	private JTextArea area;
	private JScrollPane scrollPane_1;
	private JTextArea list;

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

	/**
	 * Create the frame.
	 */
	public Chat() {
		setTitle("\uC990\uAC70\uC6B4 \uCC44\uD305.. ^^*");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 380);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(4, 0));

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 8));

		panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(2, 0, 0, 3));

		globalsend = new JTextField();
		panel_2.add(globalsend);
		globalsend.setColumns(10);

		panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(30, 0));

		whom = new JLabel("\uADD3\uC18D\uB9D0");
		whom.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		panel_3.add(whom, BorderLayout.WEST);

		whomsend = new JTextField();
		whomsend.setPreferredSize(new Dimension(100, 25));
		panel_3.add(whomsend, BorderLayout.CENTER);
		whomsend.setColumns(10);
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		area = new JTextArea();
		scrollPane.setViewportView(area);

		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 5));

		panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new GridLayout(3, 0, 0, 5));

		rename = new JButton("\uB300\uD654\uBA85\uBCC0\uACBD");
		rename.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		rename.setPreferredSize(new Dimension(120, 23));
		rename.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		rename.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_4.add(rename);

		paper = new JButton("\uCABD\uC9C0\uBCF4\uB0B4\uAE30");
		paper.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		paper.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_4.add(paper);

		close = new JButton("\uB098  \uAC00  \uAE30");
		close.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		close.setPreferredSize(new Dimension(85, 25));
		close.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_4.add(close);
		
		scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);
		
		list = new JTextArea();
		list.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane_1.setViewportView(list);
	}

}
