package com.kitri.awt.event;

import java.awt.*;

public class BaseBall extends Frame {

	Panel pC = new Panel();
	Panel pE = new Panel();
	
	Panel pCS = new Panel();
	
	TextArea ta = new TextArea();
	
	Label l = new Label("입력");
	TextField tf = new TextField();
	
	Button newG = new Button("새게임");
	Button clear = new Button("지우기");
	Button dap = new Button("정답");
	Button fontC = new Button("글자색");
	Button exit = new Button("종료");
	
	BaseBallController baseBallController;
	FontColorChooser fontColorChooser = new FontColorChooser();//main 클래스인 BB와 FCㅊ는 has a 관계임
	
	public BaseBall() {
		super("BaseBall");
		
		pCS.setLayout(new BorderLayout(10, 0));
		pCS.add(l, "West");
		pCS.add(tf, "Center");
		
		pC.setLayout(new BorderLayout(0, 10));
		ta.setEditable(false);
//		ta.setEnabled(false);//이거 쓰면 버튼 눌러서 값 입력되게도 못하나?
		ta.setFont(new Font("consolas", Font.BOLD, 12));
		pC.add(ta, "Center");
		pC.add(pCS, "South");
		
		pE.setLayout(new GridLayout(5, 1, 0, 10));
		pE.add(newG);
		pE.add(clear);
		pE.add(dap);
		pE.add(fontC);
		pE.add(exit);
		
		setLayout(new BorderLayout(10, 10));
		add(pC, "Center");
		add(pE, "East");
		
		setBounds(400, 300, 500, 400);
		setVisible(true);
		
		baseBallController = new BaseBallController(this);
		
//		baseball 창 이벤트 등록
		newG.addActionListener(baseBallController);
		clear.addActionListener(baseBallController);
		dap.addActionListener(baseBallController);
		fontC.addActionListener(baseBallController);
		exit.addActionListener(baseBallController);
		tf.addActionListener(baseBallController);
		this.addWindowListener(baseBallController);
		
		
//		fontcolorchooser창 이벤트 등록
		fontColorChooser.sbR.addAdjustmentListener(baseBallController);
		fontColorChooser.sbG.addAdjustmentListener(baseBallController);
		fontColorChooser.sbB.addAdjustmentListener(baseBallController);
		fontColorChooser.ok.addActionListener(baseBallController);
		fontColorChooser.addWindowListener(baseBallController);
		fontColorChooser.addWindowListener(baseBallController);
	}
	
	
	public static void main(String[] args) {
		new BaseBall();
	}
}
