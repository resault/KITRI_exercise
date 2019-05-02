package com.kitri.thread;

public class RunnableTest {

	public static void main(String[] args) {
		Thread t1 = new Thread(new RunnableImpl("퐁"));
		Thread t2 = new Thread(new RunnableImpl("당"));
		Thread t3 = new Thread(new RunnableImpl("!!!"));
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("프로그램 종료!!!");
	}
}
