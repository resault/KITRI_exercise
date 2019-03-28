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
public class ItemTest extends Frame implements ItemListener, ActionListener {

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
//		exit.addActionListener(new ItemTest()); //���ο� ItemTest�� ��� ������
		exit.addActionListener(this);
		mor.addItemListener(this);
		aft.addItemListener(this);
		eve.addItemListener(this);
		app.addItemListener(this);
		banana.addItemListener(this);
		straw.addItemListener(this);
		ch.addItemListener(this);
		
	}
	
	
	public static void main(String[] args) {
		new ItemTest();
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		Object ob = e.getSource();
		if(ob == ch) {
			String str = ch.getSelectedItem();
			if(str.equals("��ħ")) 
				mor.setState(true);
			else if(str.equals("����")) 
				aft.setState(true);
			else
				eve.setState(true);
		}
		
		Checkbox sel = cg.getSelectedCheckbox();
		String selstr = sel.getLabel();
//		System.out.println(selstr); //console�� ����
		ta.setText("--- " + selstr + " ---\n");
//		ta.append("1. ��� : " + (app.getState() ? "�Ծ���." : "�ȸԾ���.") + '\n');
//		ta.append("2. �ٳ��� : "+ (banana.getState() ? "�Ծ���." : "�ȸԾ���.")  + '\n');
//		ta.append("3. ���� : "+ (straw.getState() ? "�Ծ���." : "�ȸԾ���.")  + '\n');
		ta.append("1. ��� : " + eat(app.getState()) + '\n');
		ta.append("2. �ٳ��� : "+ eat(banana.getState())  + '\n');
		ta.append("3. ���� : "+ eat(straw.getState())  + '\n');
		ch.select(selstr);
		
		
	}
	
	private String eat(boolean flag) {
		return flag ? "�Ծ���." : "�ȸԾ���.";
	}
}
 
