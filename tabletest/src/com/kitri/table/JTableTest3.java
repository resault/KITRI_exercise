package com.kitri.table;


import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTableTest3 extends JFrame{

	JPanel contentPane = new JPanel();
	
	String[] colName = {"과목", "교재", "진행상황"};
	String[][] rowData = {{"Oracle", "NCS기반의...", "종료"},
						{"Java", "이것이 자바다", "진행중"},
						{"HTML", "미확인", "수강예정"}, 
						{"JSP", "미확인", "수강예정"}};
	
	DefaultTableModel model;
	JTable table;
	JScrollPane scrollPane;

	
	public JTableTest3() {
		
		model = new DefaultTableModel(rowData, colName);
		table = new JTable(model);
		table.setFillsViewportHeight(true);
		scrollPane = new JScrollPane(table);
		
		contentPane.setLayout(new BorderLayout());
		contentPane.add(scrollPane);
		
//		setLayout(new BorderLayout());
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	
	}
	
	public static void main(String[] agrs) {
		
		JTableTest3 test = new JTableTest3();
	}
}
