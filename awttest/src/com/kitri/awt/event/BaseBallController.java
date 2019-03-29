package com.kitri.awt.event;

import java.awt.Color;
import java.awt.event.*;

public class BaseBallController implements ActionListener, AdjustmentListener{//신호등 역할! (ListTest의 if문 같은)
	
	BaseBall baseBall;
	BaseBallService baseBallService;
	
	public BaseBallController(BaseBall baseBall) {
		this.baseBall = baseBall;
		baseBallService = new BaseBallService(this);//인자값을 baseBall로 주면, sevice에서 colorchange를 또 새로 불러와야함..??
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == baseBall.newG ) {
			baseBallService.newG();
		} else if(ob == baseBall.clear ) {
			baseBallService.clear();
		} else if(ob == baseBall.dap ) {
			baseBallService.showDap();
		} else if(ob == baseBall.fontC ) {
			baseBallService.fontColorChange();
		} else if(ob == baseBall.exit ) {
			baseBallService.exit();
		} else if(ob == baseBall.tf ) {
			baseBallService.game();
		} else if(ob == baseBall.fontColorChooser.ok) {
			baseBallService.selectColor();
		}
	}
	
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		baseBallService.changeColor();
	}

	
	
}
