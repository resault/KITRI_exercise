package com.kitri.util;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		Random random = new Random();
		
		//1) nextBoolean() : 무작위로 참/거짓
		boolean b = random.nextBoolean();
		System.out.println(b);
		
		//2) nextDouble() : double 범위 내에서 무작위로 double값 생성
		double d = random.nextDouble();
		System.out.println("d == " + d);

		//3) nextInt()
		int i = random.nextInt();
		System.out.println("i == " + i);
		
		//4) nextInt(int bound) : 0부터 인자값 -1 까지 사이의 범위 내에서 무작위로 int 값 생성 (가장 많이 사용)
		int r = random.nextInt(256);
		System.out.println("r == " + r);
		
		
	}
}
