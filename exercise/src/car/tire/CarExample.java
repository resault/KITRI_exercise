package car.tire;

public class CarExample {
	public static void main(String[] args) {

		Car car = new Car();

		for (int i = 1; i <= 5; i++) {
			int problemlocation = car.run();

			switch (problemlocation) {
			case 1:
				System.out.println("�տ��� HanKookTire�� ��ü");
				car.frontLeftTire = new HankookTire("�տ���", 15);// �ʵ忡 ��ü�� �����ؼ� �����Ѵٰ�?
				break;
			case 2:
				System.out.println("�տ����� KumhoTire�� ��ü");
				car.frontLeftTire = new KumhoTire("�տ���", 13);
				break;
			case 3:
				System.out.println("�ڿ��� HanKookTire�� ��ü");
				car.frontLeftTire = new HankookTire("�տ���", 14);
				break;
			case 4:
				System.out.println("�ڿ����� KumhoTire�� ��ü");
				car.frontLeftTire = new KumhoTire("�տ���", 17);
				break;
			}
			System.out.println("---------------------------------------------");

		}
	}
}
