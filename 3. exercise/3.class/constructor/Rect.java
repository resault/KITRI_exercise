/*
1. 가로 width, 세로 height
2. 넓이 : calcArea()
   둘레 : calcRound()
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
		System.out.println("가로가 "+width+"이고 세로가 "+height+"인 사각형의 넓이는 "+area+"이고 둘레는 "+round+"입니다.");
	}
}
