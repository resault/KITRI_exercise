public class CarUser {
	public static void main(String[] args) {

		Car car1 = new Car();

		//1. ���̸� : K5 ���� : ��� ������ : ���
		Car car2 = new Car("K5", "���", "���");
		car2.info();

		//�ӵ��� 85 ����!!!
		car2.speedInfo(85);

		System.out.println(car1 + "    " + car2);
	}
}
