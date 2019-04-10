package com.kitri.chat.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.Font;

public class Paper extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextArea textArea;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_1;
	private JPanel panel_4;
	private JButton send;
	private JButton answer;
	private JButton cansel;
	private JScrollPane scrollPane;


	/**
	 * Create the frame.
	 */
	public Paper() {
		setTitle("\uCABD\uC9C0\uBCF4\uB0B4\uAE30~~~");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 294, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 2, 0, 0));

		panel_2 = new JPanel();
		panel.add(panel_2);

		lblNewLabel = new JLabel("From : ");
		panel_2.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("from");
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setPreferredSize(new Dimension(60, 25));
		panel_2.add(lblNewLabel_1);

		panel_3 = new JPanel();
		panel.add(panel_3);

		lblNewLabel_2 = new JLabel("To : ");
		panel_3.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("to");
		lblNewLabel_3.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lblNewLabel_3.setPreferredSize(new Dimension(60, 25));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_3);

		panel_1 = new JPanel();
		FlowLayout fl_panel_1 = (FlowLayout) panel_1.getLayout();
		fl_panel_1.setHgap(7);
		contentPane.add(panel_1, BorderLayout.SOUTH);

		panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(70, 25));
		panel_1.add(panel_4);
		panel_4.setLayout(new CardLayout(0, 0));

		send = new JButton("\uBCF4\uB0B4\uAE30");
		send.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		send.setPreferredSize(new Dimension(70, 25));
		panel_4.add(send, "name_295371070274100");

		answer = new JButton("\uB2F5\uBCC0");
		answer.setPreferredSize(new Dimension(70, 25));
		panel_4.add(answer, "name_295262612488800");

		cansel = new JButton("\uCDE8\uC18C");
		cansel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		cansel.setPreferredSize(new Dimension(70, 25));
		panel_1.add(cansel);

		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paper frame = new Paper();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
