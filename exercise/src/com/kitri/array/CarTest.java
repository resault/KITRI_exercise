package com.kitri.array;

public class CarTest {
	
	public static void main(String[] args) {
		Car car1 = new Car("현대", "쏘나타", "검정색");
		Car car2 = new Car("기아", "K5", "하얀색");
		
		System.out.println(car1.getCarName());
		System.out.println(car2.getCarName());
		
		car1 = car2;
		
		System.out.println(car1.getCarName());
		System.out.println(car2.getCarName());
		
		car1.setCarName("애니");
		System.out.println(car1.getCarName());
		System.out.println(car2.getCarName());
		
		System.out.println(car1 == car2);
	}
}
