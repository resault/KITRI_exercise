package study0328;

import java.awt.*;

public class VendigMachine extends Frame{

	Panel pC = new Panel();
	Panel pCC = new Panel();
	Panel pCC1 = new Panel();
	Panel pCC12 = new Panel();
	Panel pCC2 = new Panel();
	Panel pCC21 = new Panel();
	Panel pCC22 = new Panel();
	Panel pCE = new Panel();
	Panel pCE1 = new Panel();
	Panel pCE2 = new Panel();
	Panel pCE3 = new Panel();
	Panel pS = new Panel();
	Panel pSE = new Panel();
	
	Panel nameP = new Panel();

	Panel coffeeP = new Panel();
	Button cof1 = new Button("�Ƹ޸�ī��\n500��");
	Button cof2 = new Button("ī���\n500��");
	Button cof3 = new Button("ī��Ḷ���ƶ�\n500��");
	
	Panel teaP = new Panel();
	Button tea1 = new Button("������\n300��");
	Button tea2 = new Button("������\n300��");
	Button tea3 = new Button("�ձ۷���\n300��");
	
	TextField intf = new TextField();
	Button inB = new Button("����");
	Button outB = new Button("�ܵ��ޱ�");
	TextField outtf = new TextField();
	
	TextField infotf = new TextField();
	Button standB = new Button();
	Button operB = new Button();
	
	
	public VendigMachine() {
		super("���Ǳ�");

		pCC12.setLayout(new GridLayout(1, 3));
		pCC12.add(cof1);
		pCC12.add(cof2);
		pCC12.add(cof3);
		
		pCC1.setLayout(new BorderLayout());
		pCC1.add(coffeeP, "North");
		pCC1.add(pCC12, "Center");

		pCC22.setLayout(new GridLayout(1, 3));
		pCC22.add(tea1);
		pCC22.add(tea2);
		pCC22.add(tea3);
		
		pCC2.setLayout(new BorderLayout());
		pCC2.add(teaP, "North");
		pCC2.add(pCC22, "Center");
		
		pCC.setLayout(new GridLayout(2, 1));
		
		pCE1.setLayout(new GridLayout(1, 2));
		pCE1.add(new Label("���� �־��ּ���!"));
		pCE1.add(intf);
		pCE2.setLayout(new GridLayout(1, 2));
		pCE2.add(inB);
		pCE2.add(outB);
		pCE3.add(outtf);

		pCE.setLayout(new GridLayout(6, 1));
		pCE.add(new Label());
		pCE.add(pCE1);
		pCE.add(pCE2);
		pCE.add(pCE3);
		
		pC.setLayout(new BorderLayout());
		pC.add(pCC, "Center");
		pC.add(pCE, "East");
		
		pS.setLayout(new BorderLayout());
		pS.add(pSE);
		
		setLayout(new BorderLayout());
		add(nameP, "North");
		add(pC, "Center");
		add(pS, "South");
		
		
		setBounds(500, 300, 500, 400);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new VendigMachine();
	}
}
