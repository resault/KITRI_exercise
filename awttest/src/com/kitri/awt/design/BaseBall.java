package com.kitri.awt.design;

import java.awt.*;

public class BaseBall extends Frame {

	Panel pC = new Panel();
	Panel pE = new Panel();
	
	Panel pCS = new Panel();
	
	TextArea ta = new TextArea();
	
	Label l = new Label("����");
	TextField tf = new TextField();
	
	Button newG = new Button("������");
	Button clear = new Button("�����");
	Button dop = new Button("����");
	Button fontC = new Button("���ڻ�");
	Button exit = new Button("����");
	
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
