package com.kitri.thread;

public class ThreadTest {

	public static void main(String[] args) {
		Thread t1 = new ThreadExt("��");//ThreadExt�� Thread�� ��ӹ޾����Ƿ�
		Thread t2 = new ThreadExt("��");
		Thread t3 = new ThreadExt("!!!");
		
		
//		t1.run();
//		t2.run();
//		t3.run();//Thread�� run()�� ���� ȣ���ϸ� VM�� Tread Schaduller�� ���� ���� �Ϲ� methodó�� ȣ��Ǿ, �ϳ��� ������ ������ ȣ���
		
		t1.start();
		t2.start();
		t3.start();
		
		
		
		System.out.println("���α׷� ����!!!");// �̰� �� �߰��� ��µ���??
	}
}
