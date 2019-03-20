public class Store {

	public static void main(String[] args)	{
		
		
		PointCard p1 = new PointCard("박미래");
		PointCard p2 = new PointCard("황선혜");
		
		System.out.println(p1.name + "님 물건 구매");
		int point = p1.visit();		
		System.out.println(p1.name + "님의 포인트는 " + point + "입니다.");

		System.out.println(p2.name + "님 물건 구매");
		point = p2.visit();		
		System.out.println(p2.name + "님의 포인트는 " + point + "입니다.");

		System.out.println(p1.name + "님 물건 구매");
		point = p1.visit();		
		System.out.println(p1.name + "님의 포인트는 " + point + "입니다."); //각 객체의 visit method가 돌아감
		
		System.out.println("-----------------------------------------------");
		
		
		
		
		//Guest g1 = new Guest("박미래");
		//Guest g2 = new Guest("황선혜");
		/*
		System.out.println(g1.name + "님 방문");
		int count = Guest.visit();		
		System.out.println(g1.name + "님은 " + count + "번째 방문자입니다.");

		System.out.println(g2.name + "님 방문");
		count = Guest.visit();		
		System.out.println(g2.name + "님은 " + count + "번째 방문자입니다.");//guest 클래스의 cnt 변수에 static 붙이면 누적결과가 나옴
		
		System.out.println(g1.name + "님 방문");
		count = Guest.visit();		
		System.out.println(g1.name + "님은 " + count + "번째 방문자입니다.");
		*/

		System.out.println("손님 방문");
		int count = Guest.visit();		
		System.out.println(count + "번째 방문자입니다.");

		System.out.println("손님 방문");
		count = Guest.visit();		
		System.out.println(count + "번째 방문자입니다.");//guest 클래스의 cnt 변수에 static 붙이면 누적결과가 나옴
		
		System.out.println("손님 방문");
		count = Guest.visit();		
		System.out.println(count + "번째 방문자입니다.");
	}

}
