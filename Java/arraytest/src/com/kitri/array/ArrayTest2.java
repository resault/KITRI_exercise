package com.kitri.array;

public class ArrayTest2 {

	public static void main(String[] args) {
		Car car[] = new Car[6];
		System.out.println(car);
		System.out.println(car[0]);
//		System.out.println(car[0].getCarName());//car[0]�� null�̶� null point exception
		car[0] = new Car("�Ÿ", "������", "����");
		car[1] = new Car("K5", "���", "���");
		car[2] = new Car("SM5", "����", "�Ｚ");
		car[3] = new Car("�ƹݶ�", "���", "����");
		car[4] = new Car("�Ͼ��", "��ѱ��", "���");
		car[5] = new Car("��Ÿ��", "������", "����");

		int len = car.length;
		for (int i = 0; i < len; i++)
			System.out.println(i + 1 + "��°���� : " + car[i]);

		// �Ͼ�� ã��
		String name = "�Ͼ��";
//		int num = 0;
//		for(int i=0;i<=len;i++) {
//			if(car[i].getCarName() == "�Ͼ��") {//���ڿ��� == ���� ����!!
//				num = i;
//				break;
//			}
//		}
//		
//		//��ѱ�� �Ͼ��(���)�� 5��°�� �ֽ��ϴ�.
//		System.out.println(car[num].getColor()+ " "+ car[num].getCarName() + "("+car[num].getMaker()+")�� "+(num+1)+"��°�� �ֽ��ϴ�.");

		for (int i = 0; i < len; i++) {
			if (name.equals(car[i].getCarName())) {
				System.out.println(car[i].getColor() + " " + car[i].getCarName() + "(" + car[i].getMaker() + ")�� "
						+ (i + 1) + "��°�� �ֽ��ϴ�.");
				break;
			}
		}

		// QM5 ã�� //answer ����!!
		

		/*
		 * boolean check = true;
		 * 
		 * for (int i = 0; i < len; i++) { if (name.equals(car[i].getCarName())) {
		 * System.out.println(car[i].getColor() + " " + car[i].getCarName() + "(" +
		 * car[i].getMaker() + ")�� " + (i + 1) + "��°�� �ֽ��ϴ�."); check = true; break; }
		 * else { check = false; } } if (check = false) System.out.println(name +
		 * "�� �����ϴ�.");
		 */

		name = "QM5";
		Car findCar = null;
		
		int count = 0;
		len = car.length;
		for (int i = 0; i < len; i++) {
			if(name.equals(car[i].getCarName())) {
				findCar = car[i];
				count = i + 1;
			}
		}
		
		if (findCar != null) {
			System.out.println(findCar.getColor() + " " + findCar.getCarName() + "(" + findCar.getMaker() + ")" + "�� " + count + "��°�� �ֽ��ϴ�.");			
		} else {
			System.out.println(name + "�� �����ϴ�.");
		}
		// switch�� �ȵǳ�?
	}
}
