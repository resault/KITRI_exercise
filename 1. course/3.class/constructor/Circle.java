/*
1. 반지름 radius
2. 넓이 : calcArea()
   둘레 : calcRound()
*/
public class Circle {
	
	int radius;

	//생성자
	public Circle() {
		this(4);
	}

	public Circle(int radius) {
		this.radius = radius;
	}


	//method
	public double calcArea() {
		return Math.pow(radius, 2) * Math.PI;//파이는 고정값이므로 상수로 사용함
	
	}

	public double calcRound() {
		return 2 * Math.PI * radius;
	
	}


	public String info() {
		double calcArea = this.calcArea();
		double calcRound = this.calcRound();
		
		return "반지름이 " + radius + "인 원의 넓이는 " +
			calcArea + "이고 둘레는 " + calcRound + "입니다." ;
	}

}