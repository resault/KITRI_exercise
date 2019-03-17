/*
1. 반지름 radius
2. 넓이 : calcArea()
   둘레 : calcRound()
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
		System.out.println("반지름이 "+radius+"인 원의 넓이는 "+area+"이고 둘레는 "+round+"입니다.");
	}
}
