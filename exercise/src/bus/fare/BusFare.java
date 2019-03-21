package bus.fare;

import java.io.*;

public class BusFare {

	BufferedReader in;
	int basicFare;
	int discountRate;

	public BusFare() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}



	public void calcDCRate(int age) throws Exception {
		if (age >= 65) {
			discountRate = 100;
		}
		if (age < 65 && age >= 20) {
			discountRate = 0;
		}
		if (age >= 14 && age < 20) {
			discountRate = 25;
		}
		if (age >= 4 && age <14) {
			discountRate = 50;
		}
		if (age >=0 && age < 4) {
			discountRate = 100;
		}
	}

	public void exit() {
		System.out.println("���α׷� ����.");
		System.exit(0);
	}

	public int calcFare(int discountRate) {
		return (int) (basicFare * (1.0 - (double) discountRate / 100));
	}

	public static void main(String[] args) throws Exception {

		BusFare bus = new BusFare();

		while (true) {
			System.out.println("���̸� �Է��ϼ���.");
			int age = Integer.parseInt(bus.in.readLine());
			bus.calcDCRate(age);
			int busfare = bus.calcFare(bus.discountRate);
			System.out.println("������� : " + busfare + "��");
			System.out.println("�����Ͻðڽ��ϱ�? : Y(0)/N(1)");
			int i = Integer.parseInt(bus.in.readLine());
			if (i == 0) {
				bus.exit();
			}
		}

	}
}
