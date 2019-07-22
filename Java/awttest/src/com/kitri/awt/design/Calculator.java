package com.kitri.awt.design;

import java.awt.*;

public class Calculator extends Frame {

	Panel pN = new Panel();
	Panel pC = new Panel();
	
	Label numL = new Label();
	Label operL = new Label();
	
	String[] btnstr = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", "C", "=", "/"};
	Button[] btn = new Button[16];
	
	Button exit = new Button("Á¾·á");
	
	public Calculator() {
		super("Calculator");
		
		pN.setLayout(new BorderLayout(5, 0));
		pN.add(numL, "Center");
		pN.add(operL, "East");
		
		pC.setLayout(new GridLayout(4, 4));
		int len = btn.length;
		int r = 140;
		int g = 140;
		int b = 140;
		for(int i = 0;i<len;i++) {
			btn[i] = new Button(btnstr[i]);
			btn[i].setFont(new Font("±¼¸²", Font.BOLD, 20));
			btn[i].setForeground(Color.WHITE);
			btn[i].setBackground(new Color(r+=5, g+=5, b+=5));;
			pC.add(btn[i]);
		}
		
		setLayout(new BorderLayout(10, 10));
		add(pN, "North");
		add(pC, "Center");
		exit.setFont(new Font(null, Font.BOLD, 15));
		add(exit, "South");
		
		setBounds(500, 300, 300, 400);
		setResizable(false);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new Calculator();
	}
}
