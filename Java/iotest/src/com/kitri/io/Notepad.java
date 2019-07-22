package com.kitri.io;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Notepad extends JFrame implements ActionListener {

	private JPanel contentPane;
	JMenuItem open = new JMenuItem("\uC5F4\uAE30");
	JMenuItem save = new JMenuItem("\uC800\uC7A5");
	JMenuItem exit = new JMenuItem("\uC885\uB8CC");
	JTextArea ta = new JTextArea();

	FileDialog fd;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notepad frame = new Notepad();
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
	public Notepad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("메모장");
		setBounds(100, 100, 378, 461);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		panel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("\uD30C\uC77C");
		menuBar.add(mnNewMenu);
		
		mnNewMenu.add(open);
		mnNewMenu.add(save);
		mnNewMenu.add(exit);
		
		JMenu mnNewMenu_1 = new JMenu("\uB3C4\uC6C0\uB9D0");
		menuBar.add(mnNewMenu_1);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_1.add(ta, BorderLayout.CENTER);
		
		open.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);
		
		fd = new FileDialog(this);
		fd.setVisible(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == exit) {
			System.exit(0);
		} else if (ob == open) {
			fd.setMode(FileDialog.LOAD);
			fd.setVisible(true);
			try {
				BufferedReader in = new BufferedReader(new StringReader(fd.getFile())); //파일명 얻어오기
				BufferedReader path = new BufferedReader(new StringReader(fd.getDirectory())); //파일 경로 얻어오기(디렉토리까지)
				String inFile = path.readLine() + File.separator +in.readLine(); //경로 구분자 넣어서 파일경로 완성
				BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream(new File(inFile)))); //파일 내용을 buffer로 읽어옴
				String str = null;
				ta.setText("");
				while((str = fin.readLine()) != null ) {
					ta.append(str + "\r\n");
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			} 
		} else if (ob == save) {
			fd.setMode(FileDialog.SAVE);
			fd.setVisible(true);
			String context = ta.getText();
			BufferedReader in = new BufferedReader(new StringReader(fd.getFile())); //파일명 얻어오기
			BufferedReader path = new BufferedReader(new StringReader(fd.getDirectory())); //파일 경로 얻어오기(디렉토리까지)
			String outFile;
			File out = null;
			FileWriter fw = null;
			try {
				outFile = path.readLine() + File.separator +in.readLine();
				out = new File(outFile);
				fw = new FileWriter(out);
				fw.write(outFile);
			} catch (IOException e1) {
				e1.printStackTrace();
			} finally {
				try {
					if(fw != null)
						fw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

	}
}
