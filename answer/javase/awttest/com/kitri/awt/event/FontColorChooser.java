package com.kitri.awt.event;

import java.awt.*;
import java.awt.event.*;

public class FontColorChooser extends Frame {

	Panel p1 = new Panel();
	Panel p11 = new Panel();
	Panel p12 = new Panel();
	Panel p13 = new Panel();
	Panel p2 = new Panel();
	Panel p21 = new Panel();
	
	Label lR = new Label("����", Label.CENTER);
	Label lG = new Label("�ʷ�", Label.CENTER);
	Label lB = new Label("�Ķ�", Label.CENTER);
	Scrollbar sbR = new Scrollbar(Scrollbar.HORIZONTAL, 127, 10, 0, 265);
	Scrollbar sbG = new Scrollbar(Scrollbar.HORIZONTAL, 127, 10, 0, 265);
	Scrollbar sbB = new Scrollbar(Scrollbar.HORIZONTAL, 127, 10, 0, 265);
	
	Panel colorP = new Panel();
	Label colorL = new Label();
	Button ok = new Button("����");
	
	public FontColorChooser() {
		super("����ǥ!!!");
		
		p11.setLayout(new BorderLayout(10, 0));
		lR.setBackground(Color.RED);
		p11.add(lR, "West");
		p11.add(sbR, "Center");
		
		p12.setLayout(new BorderLayout(10, 0));
		lG.setBackground(Color.GREEN);
		p12.add(lG, "West");
		p12.add(sbG, "Center");
		
		p13.setLayout(new BorderLayout(10, 0));
		lB.setBackground(Color.BLUE);
		p13.add(lB, "West");
		p13.add(sbB, "Center");
		
		p1.setLayout(new GridLayout(5, 1, 0, 20));
		p1.add(new Label(""));
		p1.add(p11);
		p1.add(p12);
		p1.add(p13);
		
		p21.setLayout(new BorderLayout(10, 0));
		p21.add(ok, "East");
		p21.add(colorL, "Center");
		
		p2.setLayout(new BorderLayout(0, 10));
		p2.add(colorP, "Center");
		p2.add(p21, "South");
		
		setLayout(new GridLayout(1, 2, 10, 0));
		add(p1);
		add(p2);
		
		setBounds(300, 200, 500, 400);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
			
		});
	}
	
}
