public class DohyungTest {
	public static void main(String[] args)	{
		
		Rect r1 = new Rect();
		//���ΰ� 4�̰� ���ΰ� 3�� �簢���� ���̴� 12�̰� �ѷ��� 14�Դϴ�. (default)
		System.out.println(r1.info());


		Rect r2 = new Rect(5,7);
		//���ΰ� 5�̰� ���ΰ� 7�� �簢���� ���̴� 35�̰� �ѷ��� 24�Դϴ�. (����, ���� ���ǰ�)
		System.out.println(r2.info());

		
		Circle c1 = new Circle();
		//�������� 4�� ���� ���̴� 48.xxx�̰� �ѷ��� 24.xx�Դϴ�. (default)
		System.out.println(c1.info());


		Circle c2 = new Circle(5);
		//�������� 5�� ���� ���̴� 75.xxx�̰� �ѷ��� 30.xx�Դϴ�. (������ ���ǰ�)
		System.out.println(c2.info());//�ε��Ҽ��� ����

	}
}
