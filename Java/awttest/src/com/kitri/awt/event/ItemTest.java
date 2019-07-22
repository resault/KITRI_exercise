package com.kitri.awt.event;

import java.awt.*;
import java.awt.event.*;

/*
1. Frame 상속
2. 선언부에 필요한 객체 생성	(생성자에서 해도 상관은 없음)
3. 배치부에서 design (component 배치)
4. 작업은 소 >> 대	(ex. 색을 칠한다음에 붙이기)
*/

/*
1. 
2. 
3. implements

*/
public class ItemTest extends Frame { 

//	선언부
	Panel pN = new Panel();
	Panel pS = new Panel();

	CheckboxGroup cg = new CheckboxGroup();
	Checkbox mor = new Checkbox("아침", cg, true);
	Checkbox aft = new Checkbox("점심", cg, false);
	Checkbox eve = new Checkbox("저녁", cg, false);

	Checkbox app = new Checkbox("사과", true);
	Checkbox banana = new Checkbox("바나나");
	Checkbox straw = new Checkbox("딸기");
	
	
	TextArea ta = new TextArea();
	
	Choice ch = new Choice();
	Button exit = new Button("종료");
	
	ItemLogic itemLogic;
	
	public ItemTest() {
		super("ItemTest");
		
		pN.setLayout(new GridLayout(2, 3, 5, 5));
		pN.add(mor);
		pN.add(aft);
		pN.add(eve);
		pN.add(app);
		pN.add(banana);
		pN.add(straw);
		
		pS.setLayout(new BorderLayout(10, 0));
		ch.add("아침");
		ch.add("점심");
		ch.add("저녁");
		pS.add(ch, "Center");
		pS.add(exit, "East");
		
		setLayout(new BorderLayout(0, 10));
		
		add(pN, "North"); 
		add(ta, "Center");
		add(pS, "South");

		setBounds(500, 300, 300, 400);
		setVisible(true);
		
//		구현부
		itemLogic = new ItemLogic(this);
		
//		exit.addActionListener(new ItemTest()); //새로운 ItemTest가 계속 생성됨
		exit.addActionListener(itemLogic);
		mor.addItemListener(itemLogic);
		aft.addItemListener(itemLogic);
		eve.addItemListener(itemLogic);
		app.addItemListener(itemLogic);
		banana.addItemListener(itemLogic);
		straw.addItemListener(itemLogic);
		ch.addItemListener(itemLogic);
		
	}
	
	
	public static void main(String[] args) {
		new ItemTest();
		
	}


}
 
