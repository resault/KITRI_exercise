package com.kitri.test5;

public class SonataArrayTest {

	public static void main(String[] args) {
		Sonata[] car = new Sonata[4];
		
		car[0] = new Sonata("���", 5000, "NF", "�¿�");
		car[1] = new Sonata("����", 7000, "Brilliant", "����");
		car[2] = new Sonata("��ȫ��", 4000, "EF", "�ý�");
		car[3] = new Sonata("������", 6000, "Hybrid", "�¿�");
		
		System.out.println("======================== Sonata ���� ���� ========================");
		int len = car.length;
		for (int i = 0; i < len; i++) {
			System.out.println(car[i].toString());
		}
	}
}
