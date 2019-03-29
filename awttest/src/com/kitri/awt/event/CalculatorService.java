package com.kitri.awt.event;

import java.awt.Font;
import java.awt.Label;

public class CalculatorService {

	CalculatorControler calculatorControler;
	private Calculator cc;
	
	double num1 = 0;
	double num2 = 0;
	double operResult;
	
	public CalculatorService(CalculatorControler calculatorControler) {
		this.calculatorControler = calculatorControler;
		cc = calculatorControler.calculator; 
	}

//	¼ýÀÚ : 0 1 2 4 5 6 8 9 10 12
//	clear : 13
//	enter : 14
//	oper : 3 7 11 15
	public void button(String btnStr) {
		int check = btnStr.charAt(0)-48;
		if(check >=0 && check < 10) {
			cc.numL.setText(btnStr);
			if(cc.operL.getText() != "") {
				num2 = check;
			} else {
				num2 = check;
			}
		} else if (btnStr == "C") {
			clear();
		} else if (btnStr == "=") {
			String temp = cc.operL.getText();
			clear();
			cc.numL.setText("" + calc(temp));
		} else {
			cc.operL.setText(btnStr);
		}
		
		
		
	}

	public void clear() {
		cc.numL.setText("");
		cc.operL.setText("");
	}
	
	public double calc(String oper) {
		if(oper == "+") 
			return num1 + num2;
		else if (oper == "£­") 
			return num1 - num2;
		else if (oper == "¡¿") 
			return num1 * num2;
		else
			return num1 / num2;
		
	}
	
	public void exit() {
		System.exit(0);
	}
	
}
