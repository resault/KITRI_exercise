public class DohyungTest {
	public static void main(String[] args) {

		//���ΰ� 4�̰� ���ΰ� 3�� �簢���� ���̴� 12�̰� �ѷ��� 14�Դϴ�.
		Rect rect1 = new Rect();
		rect1.info();

		//���ΰ� 5�̰� ���ΰ� 7�� �簢���� ���̴� 35�̰� �ѷ��� 24�Դϴ�.
		Rect rect2 = new Rect(5, 7);
		rect2.info();

		//�������� 4�� ���� ���̴� 48.xxx�̰� �ѷ��� 24.xxx�Դϴ�.
		Circle circle1 = new Circle();
		circle1.info();

		//�������� 5�� ���� ���̴� 75.xxx�̰� �ѷ��� 30.xxx�Դϴ�.
		Circle circle2 = new Circle(5);
		circle2.info();
	}
}
