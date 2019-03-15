/*
1. ������ radius
2. ���� : calcArea()
   �ѷ� : calcRound()
*/
public class Circle {
	
	int radius;

	//������
	public Circle() {
		this(4);
	}

	public Circle(int radius) {
		this.radius = radius;
	}


	//method
	public double calcArea() {
		return Math.pow(radius, 2) * Math.PI;//���̴� �������̹Ƿ� ����� �����
	
	}

	public double calcRound() {
		return 2 * Math.PI * radius;
	
	}


	public String info() {
		double calcArea = this.calcArea();
		double calcRound = this.calcRound();
		
		return "�������� " + radius + "�� ���� ���̴� " +
			calcArea + "�̰� �ѷ��� " + calcRound + "�Դϴ�." ;
	}

}