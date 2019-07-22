package com.kitri.awt.event;

import java.awt.Checkbox;
import java.awt.event.*;

public class ItemLogic implements ItemListener, ActionListener {
	
	
//	ItemTest itemTest = new ItemTest(); //ÀÌ·¸°Ô ÇÏ¸é °´Ã¼°¡ ¹«ÇÑ»ý¼ºµÊ
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
			if(str.equals("¾ÆÄ§")) 
				itemTest.mor.setState(true);
			else if(str.equals("Á¡½É")) 
				itemTest.aft.setState(true);
			else
				itemTest.eve.setState(true);
		}
		
		Checkbox sel = itemTest.cg.getSelectedCheckbox();
		String selstr = sel.getLabel();
//		System.out.println(selstr); //console¿¡ ÂïÈû
		itemTest.ta.setText("--- " + selstr + " ---\n");
//		ta.append("1. »ç°ú : " + (app.getState() ? "¸Ô¾ú´Ù." : "¾È¸Ô¾ú´Ù.") + '\n');
//		ta.append("2. ¹Ù³ª³ª : "+ (banana.getState() ? "¸Ô¾ú´Ù." : "¾È¸Ô¾ú´Ù.")  + '\n');
//		ta.append("3. µþ±â : "+ (straw.getState() ? "¸Ô¾ú´Ù." : "¾È¸Ô¾ú´Ù.")  + '\n');
		itemTest.ta.append("1. »ç°ú : " + eat(itemTest.app.getState()) + '\n');
		itemTest.ta.append("2. ¹Ù³ª³ª : "+ eat(itemTest.banana.getState())  + '\n');
		itemTest.ta.append("3. µþ±â : "+ eat(itemTest.straw.getState())  + '\n');
		itemTest.ch.select(selstr);
	}
	
	private String eat(boolean flag) {
		return flag ? "¸Ô¾ú´Ù." : "¾È¸Ô¾ú´Ù.";
	}
}
