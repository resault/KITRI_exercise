/*
1. 반지름 radius
2. 넓이 : calcArea()
   둘레 : calcRound()
*/
public class Circle {
	
	int radius;

	public Circle() {
		this(4);
	}

	public Circle(int radius) {
		this.radius = radius;
	}

	double calcArea() {
		return Math.PI * Math.pow(radius, 2) ;
	}

	double calcRound() {
		return 2 * Math.PI * radius;
	}

}
