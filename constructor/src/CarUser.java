public class CarUser {
	public static void main(String[] args)	{

		Car car1 = new Car();
		System.out.println(" 1. ���̸� : " + car1.carName + " ���� : " + car1.color + " ������ : " + car1.maker);

		Car car2 = new Car("���");
		System.out.println(" 2. ���̸� : " + car2.carName + " ���� : " + car2.color + " ������ : " + car2.maker);

		Car car3 = new Car("�׷���", "���");
		System.out.println(" 3. ���̸� : " + car3.carName + " ���� : " + car3.color + " ������ : " + car3.maker);

		Car car4 = new Car("k5", "����", "���");
		System.out.println(" 4. ���̸� : " + car4.carName + " ���� : " + car4.color + " ������ : " + car4.maker);

		System.out.println("car4�� �ӵ��� 3ȸ ����!!");
		for (int i=0;i<3;i++)
			car4.speedUp();
		System.out.println("car4�ӵ� : " + car4.speed);
		
		System.out.println("car4�� �ӵ��� 85 ����!!");
		int speed = car4.speedUp(85);	//���� ������ speed�� ��� �ٸ��� �ص� �� �ٸ� �ǹ̸� ���߱� ���ؼ�
		System.out.println("car4 ����� �ӵ� : " + speed);
		System.out.println("car4 ���� �ӵ� : " + car4.speed);


		System.out.println(car1.info());	//�ݺ��ǹǷ�, info�޼ҵ� ��������
		System.out.println(car2.info());
		System.out.println(car3.info());
		System.out.println(car4.info());
	}
}
