package com.kitri.awt.design;

import java.awt.*;

import javafx.scene.layout.Border;

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
	Scrollbar sbR = new Scrollbar(Scrollbar.HORIZONTAL);
	Scrollbar sbG = new Scrollbar(Scrollbar.HORIZONTAL);
	Scrollbar sbB = new Scrollbar(Scrollbar.HORIZONTAL);
	
	
	Label colorL = new Label();
	
	Button ok = new Button("ok");
	
	
	public ColorSelector() {
		super("ColorSelector");

		pLL.setBackground(Color.BLUE);
		pLL.setLayout(new BorderLayout());
		pLL.add(lR, "North");
		pLL.add(lG, "Center");
		pLL.add(lB, "South");
		
		pLR.setBackground(Color.GREEN);
		pLR.setLayout(new BorderLayout());
		pLR.add(sbR, "North");
		pLR.add(sbG, "Center");
		pLR.add(sbB, "South");

		pLC.setBackground(Color.PINK);
		pLC.setLayout(new BorderLayout());
		pLC.add(pLL, "West");
		pLC.add(pLR, "Center");
		
		
		pL.setBackground(Color.GRAY);
		pL.setLayout(new BorderLayout());//o
		pL.add(pLC, "North");
		
		
		
		
		
		
		pRS.setBackground(Color.ORANGE);
		pRS.setLayout(new BorderLayout());
		pRS.add(colorL, "Center");
		pRS.add(ok, "East");
		
		pR.setBackground(Color.RED);
		pR.setLayout(new BorderLayout());
		pR.add(pRS, "South");
		colorP.setBackground(Color.CYAN);
		pR.add(colorP, "Center");

		setBackground(Color.YELLOW);
		setLayout(new GridLayout(0, 2));//end
		add(pL);
		add(pR);
		
		
		setBounds(300, 400, 300, 500);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new ColorSelector();
	}
}
