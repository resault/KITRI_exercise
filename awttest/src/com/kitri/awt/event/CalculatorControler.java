package com.kitri.awt.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorControler implements ActionListener{

	Calculator calculator;
	CalculatorService calculatorService;
	
	public CalculatorControler(Calculator calculator) {
		this.calculator = calculator;
		calculatorService = new CalculatorService(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		int len = calculator.btn.length;
		for(int i = 0; i < len; i++) {
			if(ob == calculator.btn[i]) {
				calculatorService.button(calculator.btn[i].getLabel());
				break;
			}
		}
		if(ob == calculator.exit) {
			calculatorService.exit();
		}
		
	}
}
