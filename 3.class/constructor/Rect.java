/*
1. 가로 width, 세로 height (default 4 * 3)
2. 넓이 : calcArea()
   둘레 : calcRound()
*/
public class Rect {
	
	//필드
	int width;
	int height;

	//생성자
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

		return "가로가 " + width + "이고 세로가 " + height + "인 사각형의 넓이는 " +
			calcArea + "이고 둘레는 " + calcRound + "입니다." ;
	}








	/*public String info() {

		return "가로가 "+ width +"이고 세로가 "+ height +"인 사각형의 넓이는 "+  + "이고 둘레는 "+  +"입니다.";*/
	
}
