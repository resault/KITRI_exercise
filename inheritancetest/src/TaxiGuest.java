public class TaxiGuest {
	public static void main(String[] args)	{
	
		Taxi t1 = new Taxi();
		System.out.println("t1 >>" + t1.toString());//�̰� defaul �����ڰ� ��ӵȰ� �ƴ϶�, super();�� ���� ȣ��ǰ�, infor �޼ҵ带 ���� name color���� ����Ѱ���


		Taxi t2 = new Taxi("K5", "��ȫ��", "���");
		System.out.println("t2 >> " + t2.toString());
/*
		int km = 20;
		System.out.println(t2 + "�� Ÿ�� ���𿡼� �������� " + km + "km�̵�!!!");
		int price = t2.calcPrice(km);
		System.out.println("��� : " + price + "��");

		km = 20;
		System.out.println(t2 + "�� Ÿ�� �������� ������� " + km + "km�̵�!!!");
		price = t2.calcPrice(km);
		System.out.println("��� : " + price + "��");
		System.out.println("�������� : " + t2.totalPrice + "��");
		

		km = 5;
		System.out.println(t2 + "�� Ÿ�� ���𿡼� �������� " + km + "km�̵�!!!");
		t2.initPrice();
		price = t2.calcPrice(km);
		int totalPrice = t2.sumPrice();
		System.out.println("��� : " + price + "��");
		System.out.println("�������� : " + totalPrice + "��");

		System.out.println();
	
		km = 20;
		System.out.println(t2 + "�� Ÿ�� �������� ������� " + km + "km�̵�!!!");
		t2.initPrice();
		price = t2.calcPrice(km);
		totalPrice = t2.sumPrice();
		System.out.println("��� : " + price + "��");
		System.out.println("�������� : " + totalPrice + "��");
	*/
		int upDown = 50;
		System.out.println("t2�� �ӵ��� " + upDown +"��ŭ ����!!");
		int speed = t2.speedUp(upDown);
		System.out.println("t2�� �ӵ� : " + speed +" " + t2.speed);

		upDown = 250;
		System.out.println("t2�� �ӵ��� " + upDown +"��ŭ ����!!");
		speed = t2.speedUp(upDown);
		System.out.println("t2�� �ӵ� : " + speed + " "+t2.speed);
/*
//toString() : �������� ���ڿ��� return
		System.out.println(t1.toString() + "       " + t2);//toString()�̶�� object�� method�� �ڵ����� ȣ�� �Ǿ� ���ڿ��� ��ȯ�Ǿ� ��µ� ����
		System.out.println(t1.toString() + "       " + t2.toString());//toString()�� ���� ����

*/

//hashcode() : �ּҰ��� ��ȯ
		Taxi t3 = new Taxi("K5", "��ȫ��", "���");
		System.out.println(t2 + "       " + t3);//?? �̰ſ� �ּҰ��� �ƴ϶� ������ ����?>> �̰� toString�� ��ü�����. ��� ���ڿ��̶� ���ո� �ϸ� ���� ��� ���ص� ����
		System.out.println(t2.hashCode() + "       " + t3.hashCode());
		
		if(t2 == t3) //�񱳿����ڴ� �⺻DT�� ��쿡 ���� ��������, ������DT�� ���� �ּҰ��� ����
			System.out.println("t2�� t3�� �ּҰ��� �������̴�.");
		else
			System.out.println("t2�� t3�� �ּҰ��� �ٸ����̴�.");

//equals()	: �ּҰ��� ��
//equals()�� overide�ؼ� �̸��� ��
		if(t2.equals(t3))
			System.out.println("t2�� t3�� ���̸��� �������̴�.");
		else
			System.out.println("t2�� t3�� ���̸��� �ٸ����̴�.");
		
	}
}
