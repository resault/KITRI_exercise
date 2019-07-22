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
	
	String[] colName = {"이름", "전화번호", "주소"};
	String[][] rowData = {{"Oracle", "010-1234-5678", "서울"},
							{"Java", "010-5678-1234", "서울"}};

	DefaultTableModel model; //테이블 생성 후에도 데이터를 추가/삭제/수정할 수 있게 해줌
	JTable table;
	
	JButton btnAdd = new JButton("추가");
	

	/**
	 * Create the frame.
	 */
	public JTableTest1() {
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
//		table = new JTable(rowData, columnNames);//이렇게 생성하면, 추후에 데이터의 변경이 어려움
		model = new DefaultTableModel(rowData, colName);//모델생성
		table = new JTable(model);//모델을 사용해 테이블 생성
		
//		scrollPane = new JScrollPane();
//		scrollPane.add(table);//스크롤팬을 따로 생성하고 add()로 테이블 붙이면 나타나지 않음.. 왜지?
//		scrollPane.setViewportView(table);//스크롤팬을 따로 생성했을 때는 setViewportView() 사용
	
		scrollPane = new JScrollPane(table);//테이블을 사용해 스크롤 팬 생성

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
		String[] add = {"HTML", "010-3333-3333", "서울"};
		model.addRow(add);//모델에 추가하면 테이블에 자동으로 추가됨
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
