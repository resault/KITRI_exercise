public class DohyungTest {
	public static void main(String[] args)	{

		Rect r1 = new Rect(4, 5);
		System.out.println("가로가 " + r1.width + ", 세로가 " + r1.height + "인 사각형의 둘레는 " +
			(int)r1.getArea() + "이고, 넓이는 " + (int)r1.getRound() + "입니다.");


		Circle c1 = new Circle(4);
		System.out.println("반지름이 " + c1.radius + "인 원의 넓이는 " + c1.getArea() + "입니다.");

		


	}
}
