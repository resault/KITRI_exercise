package com.ex.st0328;

import java.awt.*;

public class VendigMachine extends Frame{

	Panel pC = new Panel();
	Panel pCC = new Panel();
	Panel pCC1 = new Panel();
	Panel pCC12 = new Panel();
	Panel pCC122 = new Panel();
	Panel pCC2 = new Panel();
	Panel pCC22 = new Panel();
	Panel pCC222 = new Panel();
	Panel pCE = new Panel();
	Panel pCE1 = new Panel();
	Panel pCE2 = new Panel();
	Panel pCE3 = new Panel();
	Panel pS = new Panel();
	Panel pSE = new Panel();
	
	Panel nameP = new Panel();
	Label nameL = new Label("Vending Machine");

	Panel coffeeP = new Panel();
	Button cof1 = new Button("아메리카노");
	Button cof2 = new Button("카페라떼");
	Button cof3 = new Button("카라멜마끼아또");
	Button cof11 = new Button("500원");
	Button cof22 = new Button("500원");
	Button cof33 = new Button("500원");
	
	Panel teaP = new Panel();
	Button tea1 = new Button("율무차");
	Button tea2 = new Button("유자차");
	Button tea3 = new Button("둥글레차");
	Button tea11 = new Button("300원");
	Button tea22 = new Button("300원");
	Button tea33 = new Button("300원");
	
	TextField intf = new TextField();
	Button inB = new Button("투입");
	Button outB = new Button("잔돈받기");
	TextField outtf = new TextField();
	
	TextArea infota = new TextArea("", 3, 3);
	Button standB = new Button("      ");
	Button operB = new Button("   ");
	
	
	public VendigMachine() {
		super("자판기");

		
		pCC122.setLayout(new GridLayout(2, 3, 5, 0));
		pCC122.add(cof1);
		pCC122.add(cof2);
		pCC122.add(cof3);
		pCC122.add(cof11);
		pCC122.add(cof22);
		pCC122.add(cof33);

		pCC12.setLayout(new BorderLayout());
		pCC12.add(new Label(), "Center");
		pCC12.add(pCC122, "South");
		
		pCC1.setLayout(new BorderLayout());
		coffeeP.add(new Label("C O F F E E"));
		pCC1.add(coffeeP, "North");
		pCC1.add(pCC12, "Center");

		
		pCC222.setLayout(new GridLayout(2, 3, 5, 0));
		pCC222.add(tea1);
		pCC222.add(tea2);
		pCC222.add(tea3);
		pCC222.add(tea11);
		pCC222.add(tea22);
		pCC222.add(tea33);
		
		pCC22.setLayout(new BorderLayout());
		teaP.add(new Label(), "Center");
		pCC22.add(pCC222, "North");
		
		pCC2.setLayout(new BorderLayout());
		teaP.add(new Label("T E A"));
		pCC2.add(teaP, "North");
		pCC2.add(pCC22, "Center");
		
		pCC.setLayout(new GridLayout(2, 1));
		pCC.add(pCC1);
		pCC.add(pCC2);
		
		
		pCE1.setLayout(new GridLayout(1, 2));
		pCE1.add(new Label("돈을 넣어주세요!"));
		pCE1.add(intf);
		pCE2.setLayout(new GridLayout(1, 2));
		pCE2.add(inB);
		pCE2.add(outB);
		pCE3.add(outtf);

		pCE.setLayout(new GridLayout(12, 1));
		pCE.add(new Label());
		pCE.add(new Label());
		pCE.add(new Label());
		pCE.add(pCE1);
		pCE.add(new Label());
		pCE.add(pCE2);
		pCE.add(new Label());
		pCE.add(pCE3);
		
		pC.setLayout(new BorderLayout(40, 10));
		pC.add(pCC, "Center");
		pC.add(pCE, "East");
		
		pSE.setLayout(new GridLayout(1, 4, 5, 0));
		pSE.add(new Label());
		pSE.add(standB);
		pSE.add(operB);
		pSE.add(new Label());
		pS.setLayout(new BorderLayout());
		pS.add(new Label(), "West");
		pS.add(pSE, "East");
		pS.add(infota, "Center");
		
		setLayout(new BorderLayout(0, 15));
		nameL.setFont(new Font("consolas", Font.BOLD, 15));
		nameP.add(nameL);
		add(nameP, "North");
		add(new Label(), "West");
		add(pC, "Center");
		add(pS, "South");
		
		
		setBounds(500, 300, 500, 450);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new VendigMachine();
	}
}
