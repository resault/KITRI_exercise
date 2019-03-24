package com.kitri.array;

public class CarTest {
	
	public static void main(String[] args) {
		Car car1 = new Car("����", "�Ÿ", "������");
		Car car2 = new Car("���", "K5", "�Ͼ��");
		
		System.out.println(car1.getCarName());
		System.out.println(car2.getCarName());
		
		car1 = car2;
		
		System.out.println(car1.getCarName());
		System.out.println(car2.getCarName());
		
		car1.setCarName("�ִ�");
		System.out.println(car1.getCarName());
		System.out.println(car2.getCarName());
		
		System.out.println(car1 == car2);
	}
}
