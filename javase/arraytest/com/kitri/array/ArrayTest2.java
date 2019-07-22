package com.kitri.array;

import java.io.UnsupportedEncodingException;

public class ArrayTest2 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		Car car[] = new Car[6];
		car[0] = new Car("�Ÿ", "������", "����");
		car[1] = new Car("K5", "���", "���");
		car[2] = new Car("SM5", "����", "�Ｚ");
		car[3] = new Car("�ƹݶ�", "���", "����");
		car[4] = new Car("�Ͼ��", "��ѱ��", "���");
		car[5] = new Car("��Ÿ��", "������", "����");
		
		int len = car.length;
		for(int i=0;i<len;i++) {
			System.out.println(i + 1 + "��°���� : " + car[i]);
		}
		
//		String name = "�Ͼ��";
		String name = "QM5";
//		��ѱ�� �Ͼ��(���)�� 5��°�� �ֽ��ϴ�.
//		QM5�� �����ϴ�.
		Car findCar = null;
		int count = 0;
		for(int i=0;i<len;i++) {
			if(name.equals(car[i].getCarName())) {			
				findCar = car[i];
				count = i + 1;
				break;
			}
		}
		
		if(findCar != null) {
			System.out.println(findCar.getColor() + " " + 
					findCar.getCarName() + "(" + findCar.getMaker() + ")�� "+ 
					count + "��°������ �ֽ��ϴ�.");
		} else {	
			System.out.println(name + "�� �����ϴ�.");
		}
		
	}
	
}


