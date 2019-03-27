package com.kitri.awt.design;

import java.awt.*;

public class BaseBall extends Frame {

	Panel pC = new Panel();
	Panel pE = new Panel();
	
	Panel pCS = new Panel();
	
	TextArea ta = new TextArea();
	
	Label l = new Label("숫자");
	TextField tf = new TextField();
	
	Button newG = new Button("새게임");
	Button clear = new Button("지우기");
	Button dop = new Button("정답");
	Button fontC = new Button("글자색");
	Button exit = new Button("종료");
	
	public BaseBall() {
		super("BaseBall");
		
		pC.setLayout(new BorderLayout());
		pC.add(ta, "Center");
		pC.add(pCS, "South");
		pCS.setLayout(new BorderLayout());
		pCS.add(l, "West");
		pCS.add(tf, "Center");
		
		pE.setLayout(new GridLayout(0, 1, 0, 5));
		pE.add(newG);
		pE.add(clear);
		pE.add(dop);
		pE.add(fontC);
		pE.add(exit);
		
		add(pC, "Center");
		add(pE, "East");
		
		setBounds(300, 400, 300, 600);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new BaseBall();
	}
}
