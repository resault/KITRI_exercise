package com.kitri.awt.event;

import java.text.DecimalFormat;

public class CalculatorService {

	CalculatorControler calculatorControler;
	private Calculator cc;

	StringBuffer btnBF = new StringBuffer();
	private double num1;
	private double num2;
	private String operStr;

	public CalculatorService(CalculatorControler calculatorControler) {
		this.calculatorControler = calculatorControler;
		cc = calculatorControler.calculator;
	}

	public void button(String btnStr) {
		cc.numL.setFont(cc.f(30));
		int btnNum = btnStr.charAt(0) - 48;
		if (btnNum >= 0 && btnNum < 10) {
			if (btnBF.length() <= 13) {
				btnBF.append(btnStr);
				cc.numL.setText(btnBF.toString());
				block(true);
				if (btnBF.charAt(0) == '0')
					btnBF.deleteCharAt(0);
			} else
				return;
		} else if (btnStr == "C") {
			clear();
			block(true);
		} else if (btnStr == "=") {
			if (!cc.operL.getText().isEmpty()) {
				num2 = Double.parseDouble(cc.numL.getText());
				operStr = cc.operL.getText();
				clear();
				calc(operStr);
			} else
				return;
		} else {
			cc.operL.setText(btnStr);
			num1 = Double.parseDouble(cc.numL.getText());
			btnBF.setLength(0);
		}
	}

	public void exit() {
		System.exit(0);
	}

	private void clear() {
		cc.numL.setText("0");
		cc.operL.setText("");
		btnBF.setLength(0);
	}

	private void calc(String operStr) {
		double result = 0;
		if (operStr == "+")
			result = num1 + num2;
		else if (operStr == "��")
			result = num1 - num2;
		else if (operStr == "��")
			result = num1 * num2;
		else {
			if (num2 != 0)
				result = num1 / num2;
			else {
				block(false);
				if (num1 != 0) {
					cc.numL.setFont(cc.f(15));
					cc.numL.setText("0���� ���� �� �����ϴ�.");
					return;
				} else {
					cc.numL.setFont(cc.f(15));
					cc.numL.setText("���ǵ��� ���� ����Դϴ�.");
					return;
				}
			}
		}
		DecimalFormat df = new DecimalFormat("#.##"); //NumberFormat�� ����Ŭ������ DecimalFormat�� �ν��Ͻ� �����ؼ� ���� pattern����
		String resultStr = df.format(result); //NumberFormat�� format() - NumberFormat�� abstract
		if (resultStr.length() <= 15) {
			cc.numL.setText(resultStr);
		} else {
			block(false);
			cc.numL.setFont(cc.f(15));
			cc.numL.setText("�������� �ʰ��Ͽ����ϴ�.");
		}
		num1 = 0; num2 = 0; operStr = "";
	}

	private void block(boolean flag) {
		cc.btn[3].setEnabled(flag);
		cc.btn[7].setEnabled(flag);
		cc.btn[11].setEnabled(flag);
		cc.btn[14].setEnabled(flag);
		cc.btn[15].setEnabled(flag);
	}
}
