package com.kitri.awt.event;

import java.awt.*;
import java.awt.event.*;

/*
1. Frame ���
2. ����ο� �ʿ��� ��ü ����	(�����ڿ��� �ص� ����� ����)
3. ��ġ�ο��� design (component ��ġ)
4. �۾��� �� >> ��	(ex. ���� ĥ�Ѵ����� ���̱�)
*/

/*
1. 
2. 
3. implements

*/
public class ItemTest extends Frame { 

//	�����
	Panel pN = new Panel();
	Panel pS = new Panel();

	CheckboxGroup cg = new CheckboxGroup();
	Checkbox mor = new Checkbox("��ħ", cg, true);
	Checkbox aft = new Checkbox("����", cg, false);
	Checkbox eve = new Checkbox("����", cg, false);

	Checkbox app = new Checkbox("���", true);
	Checkbox banana = new Checkbox("�ٳ���");
	Checkbox straw = new Checkbox("����");
	
	
	TextArea ta = new TextArea();
	
	Choice ch = new Choice();
	Button exit = new Button("����");
	
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
		ch.add("��ħ");
		ch.add("����");
		ch.add("����");
		pS.add(ch, "Center");
		pS.add(exit, "East");
		
		setLayout(new BorderLayout(0, 10));
		
		add(pN, "North"); 
		add(ta, "Center");
		add(pS, "South");

		setBounds(500, 300, 300, 400);
		setVisible(true);
		
//		������
		itemLogic = new ItemLogic(this);
		
//		exit.addActionListener(new ItemTest()); //���ο� ItemTest�� ��� ������
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
 
