package com.kitri.chat.client;

import java.awt.event.*;

public class ChatClientController implements ActionListener{

	Login l;
	ChatClientService ccs;
	
	
	
	public ChatClientController(Login login) {
		l = login;
		ccs = new ChatClientService(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == l.ok) {
			ccs.connectProcess();
		} else if(ob == l.cancle) {
			System.exit(0);
		} else if(ob == l.chat.close) {
			ccs.closeProcess();
		}
	}
}
