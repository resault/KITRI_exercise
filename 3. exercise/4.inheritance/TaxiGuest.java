public class TaxiGuest {
	public static void main(String[] args) {

		int km;
		int speed;

		//t1 >> ���뿡�� ���� ������ �Ÿ�ý�  �⺻��� : 0
		Taxi t1 = new Taxi();//�����Ǿ� �ִ� default constructor �� super();�� ���� ��ü ������
		//overriding�ϴ� ���, ����Ŭ������ method�� �켱������ ����
		System.out.println(t1.toString()+"   �⺻���: "+ t1.basicPrice);

		//t2 >> ��ƿ��� ���� ��ȫ�� K5�ý�  �⺻��� : 0
		Taxi t2 = new Taxi("K5", "��ȫ��", "���");
		System.out.println(t2.toString()+"   �⺻���: "+ t2.basicPrice);

		//��ƿ��� ���� ��ȫ�� K5�ýø� Ÿ�� ���𿡼� �������� 20km �̵�!!!
		km = 20;
		System.out.println(t2+"�� Ÿ�� ���𿡼� �������� " + km +"km �̵�!!!");
		//��� : 5800��
		//���� ���� : 5800��
		t2.initPrice();
		t2.sumPrice(km);

		//��ƿ��� ���� ��ȫ�� K5�ýø� Ÿ�� �������� ������� 20km �̵�!!!(�ɾ�)
		km = 20;
		System.out.println(t2+"�� Ÿ�� �������� ������� " + km +"km �̵�!!!");
		//��� : 5800��
		//���� ���� : 11600��
		t2.initPrice();
		t2.sumPrice(km);


		//t2�� �ӵ��� 50��ŭ ����!!!
		//t2�� �ӵ� : 50  50
		speed = 50;
		t2.speedInfo(50);
		System.out.println("���� �ӵ�: " + t2.speed);

		//t2�� �ӵ��� 250��ŭ ����!!!
		//t2�� �ӵ� : 150  150
		speed = 250;
		t2.speedInfo(250);
		System.out.println("���� �ӵ�: " + t2.speed);


		Taxi t3 = new Taxi("K5", "��ȫ��", "���");
		//��ƿ��� ���� ��ȫ�� K5�ý�   ��ƿ��� ���� ��ȫ�� K5�ý�
		System.out.println(t2.toString() + "   " + t3.toString());
		//t1 �ּҰ�   t2�ּҰ�
		//System.out.println(t2 + t3);//��ü���� ���ؼ� �����߻�
		System.out.println(t2+ "   " + t3);//��ü�� ���ڿ��� ���ؼ� toString() �ڵ� ȣ��
		System.out.println(t2.toString() + t3);
		//t2�� t3�� �ּҰ��� �ٸ����̴�.
		//t2�� t3�� ���̸��� �������̴�.
	}
}