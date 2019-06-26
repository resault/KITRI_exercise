package com.kitri.image;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class imagetest1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					imagetest1 frame = new imagetest1();
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
	public imagetest1() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				Dimension d = getSize();
				ImageIcon imageIcon = new ImageIcon("E:\\exercise\\imagetest\\src\\image\\magnifying-glass.png");
				Image image = imageIcon. getImage();
				g.drawImage(image, 0, 0, d.width, d.height, null);
				setOpaque(true);//true로 설정하면 패널에 지정한 배경색이 나타남
				super.paintComponent(g);
			}
			
		
		};
		
		panel.setBounds(69, 32, 176, 141);
		contentPane.add(panel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);
	}
}
