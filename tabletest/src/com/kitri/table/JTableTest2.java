package com.kitri.table;

//���̺��� ����Ŭ���ص� ������ �� ���� ����?!
// >>DefaultTableModel�� ��ӹ޾Ƽ� isCellEditable()�� override�Ͽ� false�� ��ȯ�ϰ� �ϸ� ��

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class JTableTest2 extends JFrame {

	private JPanel contentPane = new JPanel();
	TableModel model = new TableModel();
	/**
	 * Create the frame.
	 */
	public JTableTest2() {
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane(model.table);
		contentPane.add(scrollPane, "Center");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);
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
}
