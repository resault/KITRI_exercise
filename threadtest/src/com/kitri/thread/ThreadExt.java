package com.kitri.thread;

public class ThreadExt extends Thread {// %Ext : ��ӹ��� Ŭ������ �ǹ���

	String msg;
	
	public ThreadExt(String msg) {
		this.msg = msg;
	}
	
	@Override
	public void run() {//extends���� ������ Thread�� ����
		for(int i=0;i<500;i++) {
			System.out.println(msg);
		}
	}
	
}
