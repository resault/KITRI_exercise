package com.kitri.table;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class JTableTest1 extends JFrame implements ActionListener{

	JPanel contentPane = new JPanel();
	JScrollPane scrollPane;
	
	String[] colName = {"�̸�", "��ȭ��ȣ", "�ּ�"};
	String[][] rowData = {{"Oracle", "010-1234-5678", "����"},
							{"Java", "010-5678-1234", "����"}};

	DefaultTableModel model; //���̺� ���� �Ŀ��� �����͸� �߰�/����/������ �� �ְ� ����
	JTable table;
	
	JButton btnAdd = new JButton("�߰�");
	

	/**
	 * Create the frame.
	 */
	public JTableTest1() {
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
//		table = new JTable(rowData, columnNames);//�̷��� �����ϸ�, ���Ŀ� �������� ������ �����
		model = new DefaultTableModel(rowData, colName);//�𵨻���
		table = new JTable(model);//���� ����� ���̺� ����
		
//		scrollPane = new JScrollPane();
//		scrollPane.add(table);//��ũ������ ���� �����ϰ� add()�� ���̺� ���̸� ��Ÿ���� ����.. ����?
//		scrollPane.setViewportView(table);//��ũ������ ���� �������� ���� setViewportView() ���
	
		scrollPane = new JScrollPane(table);//���̺��� ����� ��ũ�� �� ����

		contentPane.add(scrollPane, BorderLayout.CENTER);
		contentPane.add(btnAdd, "South");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);
		setVisible(true);
		
		btnAdd.addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		String[] add = {"HTML", "010-3333-3333", "����"};
		model.addRow(add);//�𵨿� �߰��ϸ� ���̺� �ڵ����� �߰���
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableTest1 frame = new JTableTest1();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



}
