public class DohyungTest {
	public static void main(String[] args)	{
		
		Rect r1 = new Rect();
		//가로가 4이고 세로가 3인 사각형의 넓이는 12이고 둘레는 14입니다. (default)
		System.out.println(r1.info());


		Rect r2 = new Rect(5,7);
		//가로가 5이고 세로가 7인 사각형의 넓이는 35이고 둘레는 24입니다. (가로, 세로 임의값)
		System.out.println(r2.info());

		
		Circle c1 = new Circle();
		//반지름이 4인 원의 넓이는 48.xxx이고 둘레는 24.xx입니다. (default)
		System.out.println(c1.info());


		Circle c2 = new Circle(5);
		//반지름이 5인 원의 넓이는 75.xxx이고 둘레는 30.xx입니다. (반지름 임의값)
		System.out.println(c2.info());//부동소수점 오류

	}
}
