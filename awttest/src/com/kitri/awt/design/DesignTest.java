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

// ctrl + shift + o >> �� Ŭ������ �ڵ����� import!

/*
1. Frame ���
2. ����ο� �ʿ��� ��ü ����	(�����ڿ��� �ص� ����� ����)
3. ��ġ�ο��� design (component ��ġ)
4. �۾��� �� >> ��	(ex. ���� ĥ�Ѵ����� ���̱�)
*/
public class DesignTest extends Frame {

	// �����
	Panel pN = new Panel(); //�Ϲ������� layoutmanager�� ��ġ�ο��� �ϱ⶧���� default �����ڸ� �����
	Panel pS = new Panel();
	
	Label l = new Label("�Է�", Label.CENTER); //default�� ����ϸ� ��ġ�ο��� setText()�� �ؾ� �ϹǷ� ���� text�̿�
	TextField tf = new TextField();
	Button send = new Button("����");
	
	TextArea ta = new TextArea();
	
	Choice ch = new Choice();
	Button exit = new Button("����");

	
	public DesignTest() {
		super("Design Test !!!"); //���� Ŭ������ Frame�� ������ ȣ��

		// ��ġ��
//		LayoutManager lm = new BorderLayout();
		pN.setLayout(new BorderLayout(10, 0));
		pN.add(l, "West");
		pN.add(tf, "Center");
		pN.add(send, "East");

		pS.setLayout(new GridLayout(1, 2, 10, 0));
		l.setBackground(new Color(210, 210, 150)); //RGB �ڵ�� �� ����
//		l.setForeground(new Color(255, 0, 0));
		l.setForeground(Color.MAGENTA); //����� ������ ���� �����ͼ� ���
		Font f = new Font("����", Font.BOLD, 20);//�ϳ����� �� ���� �͸�, ������ ������ ���� �����ؼ� ����
		l.setFont(f);
		
		ch.add("����");
		ch.add("���, ��õ");
		ch.add("����");
		ch.add("��û");
		pS.add(ch);
		pS.add(exit);

		setLayout(new BorderLayout(0, 10));
		
		add(pN, "North");
		add(ta, "Center");
		add(pS, BorderLayout.SOUTH);
		
//		setLocation(300, 200);
//		setSize(300, 400);
		setBounds(300, 200, 300, 500); //ũ��� ��ġ�� ���� �Ѵ� �����ϹǷ�...!!
//		setResizable(false);
		setVisible(true); //��ġ���� �������� ��ġ��ų ��!
		
	
	}
	
	public static void main(String[] args) {
		new DesignTest(); //�͸����� ��ü ���� (�ش� Ŭ������ �޼ҵ� ���� �߰��� ȣ���� ���� ���� ��쿡!)
		
	}
}
