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
//			System.out.println("0으로 나눌 수 없습니다.");
//		}
		//run time exception이기 때문에 예외처리가 아니라 logic으로 처리해야 하므로 위 방법은 좋은 방법이 아님
		
		
//		2.
		int y = random.nextInt(5);
		if(y != 0) {
			int x = 30;
			int z = x / y;
			System.out.println("x / y = " + z);
		} else
			System.out.println("0으로 나눌 수 없습니다.");
//		이 방법은 에러자체가 발생하지 않는다는 점에서 1번과 다름
		
//		3.
//		int x = 30;
//		int y = random.nextInt(4) + 1;
//		int z = x / y;
//		System.out.println("x / y = " + z);
		
		
	}
	
}
