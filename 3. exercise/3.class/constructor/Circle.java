/*
1. ������ radius
2. ���� : calcArea()
   �ѷ� : calcRound()
*/
public class Circle {
	//field
	int radius;

	//constructor
	public Circle() {
		radius = 4;
	}

	public Circle(int radius) {
		this.radius = radius;
	}

	//method
	public double calcArea() {
		double area = radius * radius * 3.14;
		return area;
	}

	public double calcRound() {
		double round = radius * 2 * 3.14;
		return round;
	}

	public void info() {
		double area = calcArea();
		double round = calcRound();
		System.out.println("�������� "+radius+"�� ���� ���̴� "+area+"�̰� �ѷ��� "+round+"�Դϴ�.");
	}
}
