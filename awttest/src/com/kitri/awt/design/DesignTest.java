package com.kitri.awt.design;

import java.awt.*;

//import java.awt.BorderLayout;
//import java.awt.Button;
//import java.awt.Choice;
//import java.awt.Frame;
//import java.awt.GridLayout;
//import java.awt.Label;
//import java.awt.LayoutManager;
//import java.awt.Panel;
//import java.awt.TextArea;
//import java.awt.TextField;

// ctrl + shift + o >> 각 클래스를 자동으로 import!

/*
1. Frame 상속
2. 선언부에 필요한 객체 생성	(생성자에서 해도 상관은 없음)
3. 배치부에서 design (component 배치)
4. 작업은 소 >> 대	(ex. 색을 칠한다음에 붙이기)
*/
public class DesignTest extends Frame {

	// 선언부
	Panel pN = new Panel(); //일반적으로 layoutmanager는 배치부에서 하기때문에 default 생성자를 사용함
	Panel pS = new Panel();
	
	Label l = new Label("입력", Label.CENTER); //default를 사용하면 배치부에서 setText()를 해야 하므로 보통 text이용
	TextField tf = new TextField();
	Button send = new Button("전송");
	
	TextArea ta = new TextArea();
	
	Choice ch = new Choice();
	Button exit = new Button("종료");

	
	public DesignTest() {
		super("Design Test !!!"); //상위 클래스인 Frame의 생성자 호출

		// 배치부
//		LayoutManager lm = new BorderLayout();
		pN.setLayout(new BorderLayout(10, 0));
		pN.add(l, "West");
		pN.add(tf, "Center");
		pN.add(send, "East");

		pS.setLayout(new GridLayout(1, 2, 10, 0));
		l.setBackground(new Color(210, 210, 150)); //RGB 코드로 색 지정
//		l.setForeground(new Color(255, 0, 0));
		l.setForeground(Color.MAGENTA); //상수로 지정된 색을 가져와서 사용
		Font f = new Font("굴림", Font.BOLD, 20);//하나에만 쓸 때는 익명, 여러개 쓸때는 변수 지정해서 생성
		l.setFont(f);
		
		ch.add("서울");
		ch.add("경기, 인천");
		ch.add("강원");
		ch.add("충청");
		pS.add(ch);
		pS.add(exit);

		setLayout(new BorderLayout(0, 10));
		
		add(pN, "North");
		add(ta, "Center");
		add(pS, BorderLayout.SOUTH);
		
//		setLocation(300, 200);
//		setSize(300, 400);
		setBounds(300, 200, 300, 500); //크기와 위치는 보통 둘다 지정하므로...!!
//		setResizable(false);
		setVisible(true); //배치부의 마지막에 위치시킬 것!
		
	
	}
	
	public static void main(String[] args) {
		new DesignTest(); //익명으로 객체 생성 (해당 클래스의 메소드 등을 추가로 호출할 일이 없을 경우에!)
		
	}
}
