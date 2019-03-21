public class DohyungTest {
	public static void main(String[] args)	{

		Rect r1 = new Rect(4, 5);
		System.out.println("가로가 " + r1.width + ", 세로가 " + r1.height + "인 사각형의 둘레는 " +
			(int)r1.getArea() + "이고, 넓이는 " + (int)r1.getRound() + "입니다.");


		Circle c1 = new Circle(5);
		System.out.println("반지름이 " + c1.radius + "인 원의 둘레는 " +
			c1.getArea() + "이고, 넓이는 " + c1.getRound() + "입니다.");

		
		//추상클래스의 객체 생성

		//Dohyung d = new Dohyung(); //추상클래스는 자신의 생성자로 객체 생성 불가
		Dohyung d1 = new Rect(5, 7);
		//System.out.println("가로가 " + r1.width + ", 세로가 " + r1.height + "인 사각형의 둘레는 " +
			//(int)r1.getArea() + "이고, 넓이는 " + (int)r1.getRound() + "입니다."); // Dohyung 클래스에는 width와 height가 없으므로 컴파일 에러 발생
		System.out.println("도형의 둘레는 " + d1.getArea() + "이고, 넓이는 " + d1.getRound() + "입니다.");//Dohyung클래스의 method는 Rect클래스의 override된 method와 링크되므로 에러 발생하지 않음

		Rect r2 = (Rect) d1;
		System.out.println("가로가 " + r1.width + ", 세로가 " + r1.height + "인 사각형의 둘레는 " +
			(int)r1.getArea() + "이고, 넓이는 " + (int)r1.getRound() + "입니다.");

		//Circle c2 = (Circle) d1;//컴파일 에러는 발생하지 않지만, 런타임시 class cast exception 발생함(Circle은 메모리에 할당되지 않았기에)

		System.out.println(r1.toString());

	}
}
