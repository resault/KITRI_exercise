package com.kitri.thread;

public class RunnableTest {

	public static void main(String[] args) {
		
//		Thread t1 = new RunnableImpl("");//RunnableImpl은 Thread를 상속받은 것이 아니므로 R..I... = Thread 아님!!
		Thread t1 = new Thread(new RunnableImpl("퐁"));//Thread의 생성자 중 Runnable을 인자값으로 받는 것을 이용하여 Thread의 인스턴스 생성
		Thread t2 = new Thread(new RunnableImpl("당"));
		Thread t3 = new Thread(new RunnableImpl("!!!"));
	
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("프로그램 종료!!!");
	}
	
}
