package com.kitri.chat.client;

import java.awt.event.*;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ChatClientController extends WindowAdapter implements ActionListener, ListSelectionListener{

	Login l;
	ChatClientService ccs;
	
	
	
	public ChatClientController(Login login) {
		l = login;
		ccs = new ChatClientService(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == l.ok || ob == l.nameTF) {
			ccs.connectProcess();
		} else if(ob == l.cancle) {
			System.exit(0);
		} else if(ob == l.chat.close) {
			ccs.closeProcess();
		} else if(ob == l.chat.globalsend) {
			ccs.globalsendProcess();
		} else if(ob == l.chat.whomsend) {
			ccs.whomsendProcess();
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		Object ob = e.getSource();
		if(ob == l) {
			System.exit(0);
		} else if(ob == l.chat) {
			ccs.closeProcess();
		} else if(ob == l.paper) {
			l.paper.toT.setText("");
			l.paper.letter.setText("");
			l.paper.setVisible(false);
		} else if(ob == l.rename) {
			l.rename.newName.setText("");
			l.rename.setVisible(false);
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		l.chat.whom.setText(l.chat.list.getSelectedValue());
	}
	
	
}
