public class CarUser {
	public static void main(String[] args) {
		//1. ���̸� :  ���� :  ������ : 
		Car car1 = new Car();
		car1.info();
		
		//1. ���̸� : �Ÿ ���� : ������ ������ : ����
		/*car1.carName = "�Ÿ";
		car1.color = "������";
		car1.maker = "����";*/ //constructor���� �ʱ�ȭ
		car1.info();
		

		//car1�� �ӵ��� 2ȸ ����!!!
		//2ȸ ���� ��  x�� �ӵ� : x
		int cnt = 2;
		/*int speed = car1.speedUp(cnt);
		System.out.println(cnt + "ȸ ���� �� " + car1.carName + "�� �ӵ�: "+ speed);*/
		car1.speedInfo(cnt);

		//car1�� �ӵ��� 8ȸ ����!!!
		//8ȸ ���� �� x�� �ӵ� : x
		cnt = 8;
		/*speed = car1.speedUp(cnt);
		System.out.println(cnt + "ȸ ���� �� " + car1.carName + "�� �ӵ�: " + speed);*/
		car1.speedInfo(cnt);

		//car1�� �ӵ��� 4ȸ ����!!!
		//4ȸ ���� �� x�� �ӵ� : x
		cnt = -4;
		/*speed = car1.speedDown(cnt);
		System.out.println(cnt + "ȸ ���� �� " + car1.carName +"�� �ӵ�: "+ speed);*/
		car1.speedInfo(cnt);

		//car1�� �ӵ��� 10ȸ ����!!!
		//10ȸ ���� �� x�� �ӵ� : x
		cnt = -10;
		/*speed = car1.speedDown(cnt);
		System.out.println(cnt + "ȸ ���� �� " + car1.carName + "�� �ӵ�: " + speed);*/
		car1.speedInfo(cnt);

		//2. ���̸� : K5 ���� : ��� ������ : ���
		Car car2 = new Car("K5", "���", "���");
		//System.out.println("2. ���̸�: " + car2.carName + " ����: " + car2.color + " ������: " + car2.maker);
		car2.info();


	}
}
