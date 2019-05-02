package com.kitri.awt.event;

import java.awt.*;

public class Calculator extends Frame {

	Panel pN = new Panel();
	Panel pC = new Panel();
	
	Label numL = new Label();
	Label operL = new Label();
	
	Button exit = new Button("종료");
	
	Font f = new Font("굴림", Font.BOLD, 20);
	
	public Calculator() {
		super("계산기");
		
		pN.setLayout(new BorderLayout(10, 0));
		numL.setBackground(Color.LIGHT_GRAY);
		operL.setBackground(Color.LIGHT_GRAY);
		pN.add(numL, "Center");
		pN.add(operL, "East");
		
		setLayout(new BorderLayout(0, 10));
		add(pN, "North");
		add(pC, "Center");
		add(exit, "South");
		
		setBounds(300, 200, 400, 500);
		setVisible(true);	
	}
	
	public static void main(String[] args) {
		new Calculator();
	}
	
}
//"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "/", "0", "C", "=", "/"