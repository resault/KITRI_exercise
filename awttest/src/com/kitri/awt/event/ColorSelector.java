package com.kitri.awt.event;

import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class ColorSelector extends Frame implements AdjustmentListener{
	
	Panel p1 = new Panel();
	Panel p11 = new Panel();
	Panel p12 = new Panel();
	Panel p13 = new Panel();
	Panel p2 = new Panel();
	Panel p2S = new Panel();
	
	
	Label lR = new Label("»¡°­", Label.CENTER);
	Label lG = new Label("ÃÊ·Ï", Label.CENTER);
	Label lB = new Label("ÆÄ¶û", Label.CENTER);
	Scrollbar sbR = new Scrollbar(Scrollbar.HORIZONTAL, 127, 10, 0, 265);
	Scrollbar sbG = new Scrollbar(Scrollbar.HORIZONTAL, 127, 10, 0, 265);
	Scrollbar sbB = new Scrollbar(Scrollbar.HORIZONTAL, 127, 10, 0, 265);
	
	
	Panel colorP = new Panel();
	Label colorL = new Label();
	Button ok = new Button("¼±ÅÃ");
	
	Font f = new Font("±¼¸²", Font.PLAIN, 15);
			
	public ColorSelector() {
		super("ColorSelector");

		p11.setLayout(new BorderLayout());
		lR.setFont(f);
		lR.setBackground(new Color(255, 36, 36));
		p11.add(lR, "West");
		p11.add(sbR, "Center");

		p12.setLayout(new BorderLayout());
		lG.setBackground(new Color(20, 255, 20));
		lG.setFont(f);
		p12.add(lG, "West");
		p12.add(sbG, "Center");
		
		p13.setLayout(new BorderLayout());
		lB.setBackground(new Color(30, 80, 255));
		lB.setFont(f);
		p13.add(lB, "West");
		p13.add(sbB, "Center");
		
		p1.setLayout(new GridLayout(7, 3, 0, 10));
		p1.add(new Label());
		p1.add(new Label());
		p1.add(p11);
		p1.add(p12);
		p1.add(p13);
		
		p2S.setLayout(new BorderLayout(10, 0));
		p2S.add(colorL, "West");
		p2S.add(ok, "Center");
		
		p2.setLayout(new BorderLayout(10, 0));
		p2.add(colorP, "Center");
		p2.add(p2S, "South");
		
		setLayout(new GridLayout(1, 2, 0, 10));
		add(p1);
		add(p2);
		
		setBounds(300, 400, 500, 300);
		setVisible(true);

		sbR.addAdjustmentListener(this);
		sbG.addAdjustmentListener(this);
		sbB.addAdjustmentListener(this);
		
		changeColor();
	}
	
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		changeColor();
	}

	private void changeColor() {
		int r = sbR.getValue();
		int g = sbG.getValue();
		int b = sbB.getValue();
		
		colorP.setBackground(new Color(r, g, b));
		colorL.setText("r = " + r + "\tg = " + g + "\tb = " + b);
	}
	
	public static void main(String[] args) {
		new ColorSelector();
	}


}
