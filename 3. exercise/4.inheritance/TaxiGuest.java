public class TaxiGuest {
	public static void main(String[] args) {

		int km;
		int speed;

		//t1 >> 현대에서 만든 검정색 쏘나타택시  기본요금 : 0
		Taxi t1 = new Taxi();//생략되어 있는 default constructor 및 super();를 통해 객체 생성됨
		//overriding하는 경우, 하위클래스의 method가 우선순위를 가짐
		System.out.println(t1.toString()+"   기본요금: "+ t1.basicPrice);

		//t2 >> 기아에서 만든 감홍색 K5택시  기본요금 : 0
		Taxi t2 = new Taxi("K5", "감홍색", "기아");
		System.out.println(t2.toString()+"   기본요금: "+ t2.basicPrice);

		//기아에서 만든 감홍색 K5택시를 타고 구디에서 강남까지 20km 이동!!!
		km = 20;
		System.out.println(t2+"를 타고 구디에서 강남까지 " + km +"km 이동!!!");
		//요금 : 5800원
		//누적 수익 : 5800원
		t2.initPrice();
		t2.sumPrice(km);

		//기아에서 만든 감홍색 K5택시를 타고 강남에서 구디까지 20km 이동!!!(심야)
		km = 20;
		System.out.println(t2+"를 타고 강남에서 구디까지 " + km +"km 이동!!!");
		//요금 : 5800원
		//누적 수익 : 11600원
		t2.initPrice();
		t2.sumPrice(km);


		//t2의 속도를 50만큼 가속!!!
		//t2의 속도 : 50  50
		speed = 50;
		t2.speedInfo(50);
		System.out.println("실제 속도: " + t2.speed);

		//t2의 속도를 250만큼 가속!!!
		//t2의 속도 : 150  150
		speed = 250;
		t2.speedInfo(250);
		System.out.println("실제 속도: " + t2.speed);


		Taxi t3 = new Taxi("K5", "감홍색", "기아");
		//기아에서 만든 감홍색 K5택시   기아에서 만든 감홍색 K5택시
		System.out.println(t2.toString() + "   " + t3.toString());
		//t1 주소값   t2주소값
		//System.out.println(t2 + t3);//객체끼리 더해서 에러발생
		System.out.println(t2+ "   " + t3);//객체에 문자열을 더해서 toString() 자동 호출
		System.out.println(t2.toString() + t3);
		//t2와 t3는 주소값이 다른차이다.
		//t2와 t3는 차이름이 같은차이다.
	}
}