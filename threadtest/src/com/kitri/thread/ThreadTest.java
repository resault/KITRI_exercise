package com.kitri.thread;

public class ThreadTest {

	public static void main(String[] args) {
		Thread t1 = new ThreadExt("퐁");//ThreadExt가 Thread를 상속받았으므로
		Thread t2 = new ThreadExt("당");
		Thread t3 = new ThreadExt("!!!");
		
		
//		t1.run();
//		t2.run();
//		t3.run();//Thread의 run()을 직접 호출하면 VM의 Tread Schaduller의 관여 없이 일반 method처럼 호출되어서, 하나가 끝나면 다음이 호출됨
		
		t1.start();
		t2.start();
		t3.start();
		
		
		
		System.out.println("프로그램 종료!!!");// 이게 왜 중간에 출력되지??
	}
}
