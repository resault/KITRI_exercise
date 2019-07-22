package com.kitri.test;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View2 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public View2() {
		setSize(477, 359);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID/Pw \uCC3E\uAE30");
		lblNewLabel.setBounds(66, 65, 107, 22);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(145, 116, 178, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\uC774\uB984");
		label.setBounds(66, 115, 67, 22);
		add(label);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(66, 171, 67, 22);
		add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(145, 172, 178, 21);
		add(textField_1);
		
		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(66, 260, 97, 23);
		add(btnNewButton);
		
		JButton button = new JButton("\uCDE8\uC18C");
		button.setBounds(226, 260, 97, 23);
		add(button);

	}

}
