public class DohyungTest {
	public static void main(String[] args)	{

		Rect r1 = new Rect(4, 5);
		System.out.println("���ΰ� " + r1.width + ", ���ΰ� " + r1.height + "�� �簢���� �ѷ��� " +
			(int)r1.getArea() + "�̰�, ���̴� " + (int)r1.getRound() + "�Դϴ�.");


		Circle c1 = new Circle(5);
		System.out.println("�������� " + c1.radius + "�� ���� �ѷ��� " +
			c1.getArea() + "�̰�, ���̴� " + c1.getRound() + "�Դϴ�.");

		
		//�߻�Ŭ������ ��ü ����

		//Dohyung d = new Dohyung(); //�߻�Ŭ������ �ڽ��� �����ڷ� ��ü ���� �Ұ�
		Dohyung d1 = new Rect(5, 7);
		//System.out.println("���ΰ� " + r1.width + ", ���ΰ� " + r1.height + "�� �簢���� �ѷ��� " +
			//(int)r1.getArea() + "�̰�, ���̴� " + (int)r1.getRound() + "�Դϴ�."); // Dohyung Ŭ�������� width�� height�� �����Ƿ� ������ ���� �߻�
		System.out.println("������ �ѷ��� " + d1.getArea() + "�̰�, ���̴� " + d1.getRound() + "�Դϴ�.");//DohyungŬ������ method�� RectŬ������ override�� method�� ��ũ�ǹǷ� ���� �߻����� ����

		Rect r2 = (Rect) d1;
		System.out.println("���ΰ� " + r1.width + ", ���ΰ� " + r1.height + "�� �簢���� �ѷ��� " +
			(int)r1.getArea() + "�̰�, ���̴� " + (int)r1.getRound() + "�Դϴ�.");

		//Circle c2 = (Circle) d1;//������ ������ �߻����� ������, ��Ÿ�ӽ� class cast exception �߻���(Circle�� �޸𸮿� �Ҵ���� �ʾұ⿡)

		System.out.println(r1.toString());

	}
}
