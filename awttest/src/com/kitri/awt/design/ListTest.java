package com.kitri.awt.design;

import java.awt.*;

public class ListTest extends Frame {

	Panel pW = new Panel();
	Panel pC = new Panel();
	Panel pE = new Panel();
	
	List listL = new List();
	Button btR = new Button();
	Button btRAll = new Button();
	Button btL = new Button();
	Button btLAll = new Button();
	List listR = new List();
	
	TextField tfL = new TextField();
	TextField tfR = new TextField();
	
	public ListTest() {
		super("ListTest");
		
		pW.setLayout(new BorderLayout(0, 10));
		pW.add(listL, "Center");
		pW.add(tfL, "South");
		
		pC.setLayout(new FlowLayout());
		pC.add(btR);
		pC.add(btRAll);
		pC.add(btL);
		pC.add(btLAll);
		
		pE.setLayout(new BorderLayout(0, 10));
		pE.add(listR, "Center");
		pE.add(tfR, "South");
		
		setLayout(new GridLayout(0, 3));
		
		add(pW);
		add(pC);
		add(pE);
		
		setBounds(300, 400, 300, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ListTest();
	}
}
