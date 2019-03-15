/*
1. 가로 width, 세로 height
2. 넓이 : calcArea()
   둘레 : calcRound()
*/
public class Rect {
	
	int width;
	int height;

	public Rect() {
		this(4, 3);
	}

	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}

	int calcArea() {
		return width * height;
	}

	int calcRound() {
		return 2 * (width + height);
	}

}
