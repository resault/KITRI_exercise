public class DohyungTest {
	public static void main(String[] args) {
		Rect r1 = new Rect();
		double area = r1.calcArea();
		double round = r1.calcRound();
		System.out.println("���ΰ� " + r1.width + "�̰� ���ΰ� " + r1.height + "�� �簢���� ���̴� " + area + "�̰� �ѷ��� " + round + "�Դϴ�.");
		//���ΰ� 4�̰� ���ΰ� 3�� �簢���� ���̴� 12�̰� �ѷ��� 14�Դϴ�.

		Rect r2 = new Rect(5, 7);
		area = r2.calcArea();
		round = r2.calcRound();
		System.out.println("���ΰ� " + r2.width + "�̰� ���ΰ� " + r2.height + "�� �簢���� ���̴� " + area + "�̰� �ѷ��� " + round + "�Դϴ�.");
		//���ΰ� 5�̰� ���ΰ� 7�� �簢���� ���̴� 35�̰� �ѷ��� 24�Դϴ�.

		Circle c1 = new Circle();
		area = c1.calcArea();
		round = c1.calcRound();
		System.out.println("�������� " + c1.radius + "�� ���� ���̴� " + area + "�̰� �ѷ��� " + round + "�Դϴ�.");
		//�������� 4�� ���� ���̴� 48.xxx�̰� �ѷ��� 24.xxx�Դϴ�.

		Circle c2 = new Circle(5);
		area = c2.calcArea();
		round = c2.calcRound();
		System.out.println("�������� " + c2.radius + "�� ���� ���̴� " + area + "�̰� �ѷ��� " + round + "�Դϴ�.");
		//�������� 5�� ���� ���̴� 75.xxx�̰� �ѷ��� 30.xxx�Դϴ�.
	}
}
