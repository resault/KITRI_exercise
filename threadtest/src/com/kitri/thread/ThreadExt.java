package com.kitri.thread;

public class ThreadExt extends Thread {// %Ext : 상속받은 클래스를 의미함

	String msg;
	
	public ThreadExt(String msg) {
		this.msg = msg;
	}
	
	@Override
	public void run() {//extends하지 않으면 Thread와 무관
		for(int i=0;i<500;i++) {
			System.out.println(msg);
		}
	}
	
}
