/*
1. ���� width, ���� height (default 4 * 3)
2. ���� : calcArea()
   �ѷ� : calcRound()
*/
public class Rect {
	
	//�ʵ�
	int width;
	int height;

	//������
	public Rect() {
		this(4, 3);
	}

	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}

	//method
	public int calcArea() {
		return width * height;
	
	}

	public int calcRound() {
		return (width + height) *2;
	
	}


	public String info() {
		int calcArea = this.calcArea();
		int calcRound = this.calcRound();

		return "���ΰ� " + width + "�̰� ���ΰ� " + height + "�� �簢���� ���̴� " +
			calcArea + "�̰� �ѷ��� " + calcRound + "�Դϴ�." ;
	}








	/*public String info() {

		return "���ΰ� "+ width +"�̰� ���ΰ� "+ height +"�� �簢���� ���̴� "+  + "�̰� �ѷ��� "+  +"�Դϴ�.";*/
	
}
