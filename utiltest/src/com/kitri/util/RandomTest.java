package com.kitri.util;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		Random random = new Random();
		
		//1) nextBoolean() : �������� ��/����
		boolean b = random.nextBoolean();
		System.out.println(b);
		
		//2) nextDouble() : double ���� ������ �������� double�� ����
		double d = random.nextDouble();
		System.out.println("d == " + d);

		//3) nextInt()
		int i = random.nextInt();
		System.out.println("i == " + i);
		
		//4) nextInt(int bound) : 0���� ���ڰ� -1 ���� ������ ���� ������ �������� int �� ���� (���� ���� ���)
		int r = random.nextInt(256);
		System.out.println("r == " + r);
		
		
	}
}
