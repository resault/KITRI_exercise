package com.kitri.awt.event;

import java.awt.Checkbox;
import java.awt.event.*;

public class ItemLogic implements ItemListener, ActionListener {
	
	
//	ItemTest itemTest = new ItemTest(); //�̷��� �ϸ� ��ü�� ���ѻ�����
	ItemTest itemTest;
	
	public ItemLogic(ItemTest itemTest) {
		this.itemTest = itemTest; //this??
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		Object ob = e.getSource();
		if(ob == itemTest.ch) {
			String str = itemTest.ch.getSelectedItem();
			if(str.equals("��ħ")) 
				itemTest.mor.setState(true);
			else if(str.equals("����")) 
				itemTest.aft.setState(true);
			else
				itemTest.eve.setState(true);
		}
		
		Checkbox sel = itemTest.cg.getSelectedCheckbox();
		String selstr = sel.getLabel();
//		System.out.println(selstr); //console�� ����
		itemTest.ta.setText("--- " + selstr + " ---\n");
//		ta.append("1. ��� : " + (app.getState() ? "�Ծ���." : "�ȸԾ���.") + '\n');
//		ta.append("2. �ٳ��� : "+ (banana.getState() ? "�Ծ���." : "�ȸԾ���.")  + '\n');
//		ta.append("3. ���� : "+ (straw.getState() ? "�Ծ���." : "�ȸԾ���.")  + '\n');
		itemTest.ta.append("1. ��� : " + eat(itemTest.app.getState()) + '\n');
		itemTest.ta.append("2. �ٳ��� : "+ eat(itemTest.banana.getState())  + '\n');
		itemTest.ta.append("3. ���� : "+ eat(itemTest.straw.getState())  + '\n');
		itemTest.ch.select(selstr);
	}
	
	private String eat(boolean flag) {
		return flag ? "�Ծ���." : "�ȸԾ���.";
	}
}
