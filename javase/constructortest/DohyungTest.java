public class DohyungTest {
	public static void main(String[] args) {
		Rect r1 = new Rect();
		double area = r1.calcArea();
		double round = r1.calcRound();
		System.out.println("가로가 " + r1.width + "이고 세로가 " + r1.height + "인 사각형의 넓이는 " + area + "이고 둘레는 " + round + "입니다.");
		//가로가 4이고 세로가 3인 사각형의 넓이는 12이고 둘레는 14입니다.

		Rect r2 = new Rect(5, 7);
		area = r2.calcArea();
		round = r2.calcRound();
		System.out.println("가로가 " + r2.width + "이고 세로가 " + r2.height + "인 사각형의 넓이는 " + area + "이고 둘레는 " + round + "입니다.");
		//가로가 5이고 세로가 7인 사각형의 넓이는 35이고 둘레는 24입니다.

		Circle c1 = new Circle();
		area = c1.calcArea();
		round = c1.calcRound();
		System.out.println("반지름이 " + c1.radius + "인 원의 넓이는 " + area + "이고 둘레는 " + round + "입니다.");
		//반지름이 4인 원의 넓이는 48.xxx이고 둘레는 24.xxx입니다.

		Circle c2 = new Circle(5);
		area = c2.calcArea();
		round = c2.calcRound();
		System.out.println("반지름이 " + c2.radius + "인 원의 넓이는 " + area + "이고 둘레는 " + round + "입니다.");
		//반지름이 5인 원의 넓이는 75.xxx이고 둘레는 30.xxx입니다.
	}
}
