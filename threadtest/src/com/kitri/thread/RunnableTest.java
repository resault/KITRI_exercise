package com.kitri.thread;

public class RunnableTest {

	public static void main(String[] args) {
		
//		Thread t1 = new RunnableImpl("");//RunnableImpl�� Thread�� ��ӹ��� ���� �ƴϹǷ� R..I... = Thread �ƴ�!!
		Thread t1 = new Thread(new RunnableImpl("��"));//Thread�� ������ �� Runnable�� ���ڰ����� �޴� ���� �̿��Ͽ� Thread�� �ν��Ͻ� ����
		Thread t2 = new Thread(new RunnableImpl("��"));
		Thread t3 = new Thread(new RunnableImpl("!!!"));
	
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("���α׷� ����!!!");
	}
	
}
