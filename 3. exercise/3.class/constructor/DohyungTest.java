public class DohyungTest {
	public static void main(String[] args) {

		//가로가 4이고 세로가 3인 사각형의 넓이는 12이고 둘레는 14입니다.
		Rect rect1 = new Rect();
		rect1.info();

		//가로가 5이고 세로가 7인 사각형의 넓이는 35이고 둘레는 24입니다.
		Rect rect2 = new Rect(5, 7);
		rect2.info();

		//반지름이 4인 원의 넓이는 48.xxx이고 둘레는 24.xxx입니다.
		Circle circle1 = new Circle();
		circle1.info();

		//반지름이 5인 원의 넓이는 75.xxx이고 둘레는 30.xxx입니다.
		Circle circle2 = new Circle(5);
		circle2.info();
	}
}
