package com.kitri.exception.runtime;

import java.util.Random;

public class ArithMeteicTest {

	public static void main(String[] args) {
		Random random = new Random();

//		1.
//		int x = 30;
//		int y = random.nextInt(5);
//		try {
//			int z = x / y;
//			System.out.println("x / y = " + z);
//		} catch(ArithmeticException e) {
//			System.out.println(e.getMessage());
//			System.out.println("0���� ���� �� �����ϴ�.");
//		}
		//run time exception�̱� ������ ����ó���� �ƴ϶� logic���� ó���ؾ� �ϹǷ� �� ����� ���� ����� �ƴ�
		
		
//		2.
		int y = random.nextInt(5);
		if(y != 0) {
			int x = 30;
			int z = x / y;
			System.out.println("x / y = " + z);
		} else
			System.out.println("0���� ���� �� �����ϴ�.");
//		�� ����� ������ü�� �߻����� �ʴ´ٴ� ������ 1���� �ٸ�
		
//		3.
//		int x = 30;
//		int y = random.nextInt(4) + 1;
//		int z = x / y;
//		System.out.println("x / y = " + z);
		
		
	}
	
}
