public class CarUser {
	public static void main(String[] args)	{
		Car car1 = null; //class����
		car1 = new Car(); //class��� >> Ŭ���� Car�� �����ڸ� ������ ���� �����̹Ƿ� default �����ڰ� ������ ���¶� ���� �ȳ�
		System.out.println("1. ���̸� : " + car1.carName + " ���� : " + car1.color + " ������ : " + car1.maker + " �ӵ�" + car1.speed);

		car1.carName = "�Ÿ";
		car1.color = "������";
		car1.maker = "����";
		System.out.println("2. ���̸� : " + car1.carName + " ���� : " + car1.color + " ������ : " + car1.maker + " �ӵ�" + car1.speed);


		Car car2 = new Car();
		car2.carName = "K5";
		car2.color = "���";
		car2.maker = "���";

		System.out.println("z. ���̸� : " + car2.carName + " ���� : " + car2.color + " ������ : " + car2.maker + " �ӵ�" + car2.speed);

		System.out.println(car1);
		System.out.println(car2);//car1, car2 �ּҰ� ��������
		


		System.out.println("���� " + car1.carName + "�� �ӵ� : " + car1.speed);
		System.out.println(car1.carName + "�� �ӵ��� 2ȸ ����!!!");
		car1.speedUp();
		car1.speedUp();
		System.out.println("2ȸ ���� �� " + car1.carName + "�� �ӵ� : " + car1.speed);
		System.out.println(car1.carName + "�� �ӵ��� 8ȸ ����!!!");
		for(int i=0;i<8;i++){
			car1.speedUp();
		}
		System.out.println("8ȸ ���� �� " + car1.carName + "�� �ӵ� : " + car1.speed);
		System.out.println(car1.carName + "�� �ӵ��� 4ȸ ����!!!");
		for(int i=0;i<4;i++){
			car1.speedDown();
		}
		System.out.println("4ȸ ���� �� " + car1.carName + "�� �ӵ� : " + car1.speed);
				System.out.println(car1.carName + "�� �ӵ��� 10ȸ ����!!!");
		for(int i=0;i<10;i++){
			car1.speedDown();
		}
		System.out.println("10ȸ ���� �� " + car1.carName + "�� �ӵ� : " + car1.speed);

	}
}
