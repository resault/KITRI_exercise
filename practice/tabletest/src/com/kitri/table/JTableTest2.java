package com.kitri.table;

//테이블을 더블클릭해도 수정할 수 없게 설정?!
// >>DefaultTableModel을 상속받아서 isCellEditable()를 override하여 false를 반환하게 하면 됨

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class JTableTest2 extends JFrame implements ActionListener{

	private JPanel contentPane = new JPanel();
	public TableModel model = new TableModel();
	/**
	 * Create the frame.
	 */
	public JTableTest2() {
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane(model.table);
		contentPane.add(scrollPane, "Center");
		
		JButton btnNewButton = new JButton("New button");
		scrollPane.setRowHeaderView(btnNewButton);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 411);
		setContentPane(contentPane);
		
		btnNewButton.addActionListener(this);
		
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableTest2 frame = new JTableTest2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int i = model.table.getSelectedRow();
		if(i > -1) {
			String name = model.table.getValueAt(i, 0).toString();
			System.out.println(name);
		} else {
			System.out.println("선택없음");
		}
	}
}
