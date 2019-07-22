package com.kitri.test5;

public class SonataArrayTest {

	public static void main(String[] args) {
		Sonata[] car = new Sonata[4];
		
		car[0] = new Sonata("흰색", 5000, "NF", "승용");
		car[1] = new Sonata("은색", 7000, "Brilliant", "업무");
		car[2] = new Sonata("감홍색", 4000, "EF", "택시");
		car[3] = new Sonata("검정색", 6000, "Hybrid", "승용");
		
		System.out.println("======================== Sonata 생산 시작 ========================");
		int len = car.length;
		for (int i = 0; i < len; i++) {
			System.out.println(car[i].toString());
		}
	}
}
