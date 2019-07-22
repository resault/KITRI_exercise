package com.kitri.awt.event;

import java.awt.*;

public class Calculator extends Frame {

//	선언부
	Panel pN = new Panel();
	Panel pNE = new Panel();
	Panel pC = new Panel();

	Label numL = new Label("0");
	Label operL = new Label();

	String[] btnstr = { "7", "8", "9", "+", "4", "5", "6", "－", "1", "2", "3", "×", "0", "C", "=", "÷" };
	Button[] btn = new Button[16];

	Button exit = new Button("종료");

	CalculatorControler calculatorControler;

//	constructor
	public Calculator() {
		super("계산기");

//		배치부
		pNE.setLayout(new GridLayout(1, 2));
		operL.setFont(f(30));
		operL.setAlignment(Label.CENTER);
		pNE.add(operL);
		pNE.add(new Label());

		pN.setLayout(new BorderLayout(20, 0));
		numL.setFont(f(30));
		numL.setAlignment(Label.RIGHT);
		pN.add(numL, "Center");
		pN.add(pNE, "East");

		pC.setLayout(new GridLayout(4, 4));
		int len = btn.length;
		int rgb = 140;
		for (int i = 0; i < len; i++) {
			btn[i] = new Button(btnstr[i]);
			btn[i].setFont(f(20));
			btn[i].setForeground(Color.WHITE);
			btn[i].setBackground(new Color(rgb, rgb, rgb += 5));
			;
			pC.add(btn[i]);
		}

		setLayout(new BorderLayout(0, 10));
		add(pN, "North");
		add(pC, "Center");
		exit.setFont(f(17));
		add(exit, "South");

		setBounds(1200, 250, 320, 450);
		setResizable(false);
		setVisible(true);

//		등록부
		calculatorControler = new CalculatorControler(this);

		for (int i = 0; i < len; i++) {
			btn[i].addActionListener(calculatorControler);
		}
		exit.addActionListener(calculatorControler);
	}

//	method
	public Font f(int size) {
		return new Font("", Font.BOLD, size);
	}

	public static void main(String[] args) {
		new Calculator();
	}
}
