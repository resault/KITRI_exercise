/*
1. ���� width, ���� height
2. ���� : calcArea()
   �ѷ� : calcRound()
*/
public class Rect {
	//field
	int width;
	int height;

	//constructor
	public Rect() {
		width = 4;
		height = 3;
	}

	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}

	//method
	public int calcArea() {
		int area = width * height;
		return area;
	}

	public int calcRound() {
		int round = (width + height ) * 2;
		return round;
	}

	public void info() {
		int area = calcArea();
		int round = calcRound();
		System.out.println("���ΰ� "+width+"�̰� ���ΰ� "+height+"�� �簢���� ���̴� "+area+"�̰� �ѷ��� "+round+"�Դϴ�.");
	}
}
