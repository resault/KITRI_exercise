package com.kitri.test5;

public class Car {

	private String color;
	private int account;
	
	public Car(String color, int account) {
		this.color = color;
		this.account = account;
	}

	@Override
	public String toString() {
		return "[색상] " + color + "\t[생산수량] " + account;
	}

	
	
}
