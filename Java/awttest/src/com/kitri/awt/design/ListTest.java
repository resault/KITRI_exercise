package com.kitri.awt.design;

import java.awt.*;

public class ListTest extends Frame {

	Panel p1 = new Panel();
	Panel p2 = new Panel();
	Panel p3 = new Panel();
	
	List listL = new List();
	TextField tfL = new TextField();
	
	Button btR = new Button("¢¹");
	Button btRAll = new Button("¢º");
	Button btL = new Button("¢·");
	Button btLAll = new Button("¢¸");
	
	List listR = new List();
	TextField tfR = new TextField();
	
	
	public ListTest() {
		super("ListTest");
		
		p1.setLayout(new BorderLayout(0, 10));
		p1.add(listL, "Center");
		p1.add(tfL, "South");
		
		p2.setLayout(new GridLayout(6, 1, 0, 10));
		p2.add(new Label());
		p2.add(btR);
		p2.add(btRAll);
		p2.add(btL);
		p2.add(btLAll);
		
		p3.setLayout(new BorderLayout(0, 10));
		p3.add(listR, "Center");
		p3.add(tfR, "South");
		
		setLayout(new GridLayout(1, 3, 10, 0));
		
		add(p1);
		add(p2);
		add(p3);
		
		setBounds(300, 400, 300, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ListTest();
	}
}
