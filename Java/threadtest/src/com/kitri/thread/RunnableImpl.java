package com.kitri.thread;

public class RunnableImpl implements Runnable{//�ٸ� Ŭ������ �̹� ��ӹ��� ���, Runnable�� implements�ϸ��

	String msg;
	
	public RunnableImpl(String msg) {
		this.msg = msg;
	}
	
	@Override
	public void run() {//extends���� ������ Thread�� ����
		for(int i=0;i<500;i++) {
			System.out.println(msg);
		}
	}
	

	
}
