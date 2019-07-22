package com.kitri.table;


import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTableTest3 extends JFrame{

	JPanel contentPane = new JPanel();
	
	String[] colName = {"����", "����", "�����Ȳ"};
	String[][] rowData = {{"Oracle", "NCS�����...", "����"},
						{"Java", "�̰��� �ڹٴ�", "������"},
						{"HTML", "��Ȯ��", "��������"}, 
						{"JSP", "��Ȯ��", "��������"}};
	
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
