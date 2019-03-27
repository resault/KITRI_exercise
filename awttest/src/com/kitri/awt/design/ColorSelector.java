package com.kitri.awt.design;

import java.awt.*;

public class ColorSelector extends Frame {
	
	Panel pL = new Panel();
	Panel pLC = new Panel();
	Panel pLL = new Panel();
	Panel pLR = new Panel();
			
	Panel pR = new Panel();
	Panel colorP = new Panel();
	Panel pRS = new Panel();
	
	
	Label lR = new Label("»¡°­");
	Label lG = new Label("ÃÊ·Ï");
	Label lB = new Label("ÆÄ¶û");
	Scrollbar sbR = new Scrollbar(Scrollbar.HORIZONTAL, 127, 5, 0, 255);
	Scrollbar sbG = new Scrollbar(Scrollbar.HORIZONTAL, 127, 5, 0, 255);
	Scrollbar sbB = new Scrollbar(Scrollbar.HORIZONTAL, 127, 5, 0, 255);
	
	
	Label colorL = new Label();
	
	Button ok = new Button("ok");
	
	
	public ColorSelector() {
		super("ColorSelector");

		pLL.setLayout(new BorderLayout(10, 10));
		pLL.add(lR, "North");
		pLL.add(lG, "Center");
		pLL.add(lB, "South");
		
		pLR.setLayout(new BorderLayout());
		sbR.add(ranger);
		pLR.add(sbR, "North");
		pLR.add(sbG, "Center");
		pLR.add(sbB, "South");
		
		
		pLC.setLayout(new BorderLayout());
		pLC.add(new Label(), "South");
		pLC.add(pLR, "Center");
		pLC.add(pLL, "West");
		pLC.add(new Label(), "North");
		
		pL.setLayout(new BorderLayout(0, 5));
		pL.add(pLC, "Center");
		pL.add(new Label(), "North");
		pL.add(new Label(), "South");
		
		
//		pRS.setBackground(Color.ORANGE);
		pRS.setLayout(new BorderLayout(5, 0));
		pRS.add(colorL, "Center");
		pRS.add(ok, "East");
		
		pR.setLayout(new BorderLayout(0, 5));
		pR.add(pRS, "South");
		pR.add(colorP, "Center");

		setLayout(new GridLayout(0, 2, 5, 0));//end
		add(pL);
		add(pR);
		
		
		setBounds(300, 400, 300, 500);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new ColorSelector();
	}
}
