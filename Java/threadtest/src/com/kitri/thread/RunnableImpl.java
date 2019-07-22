package com.kitri.thread;

public class RunnableImpl implements Runnable{//다른 클래스를 이미 상속받은 경우, Runnable을 implements하면됨

	String msg;
	
	public RunnableImpl(String msg) {
		this.msg = msg;
	}
	
	@Override
	public void run() {//extends하지 않으면 Thread와 무관
		for(int i=0;i<500;i++) {
			System.out.println(msg);
		}
	}
	

	
}
