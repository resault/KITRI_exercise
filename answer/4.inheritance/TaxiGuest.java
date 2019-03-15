import java.util.*;

public class TaxiGuest {
	public static void main(String[] args) {
		Taxi t1 = new Taxi();
		System.out.println("t1 >> " + t1.toString() + "  기본요금 : "  + t1.basicPrice);

		Taxi t2 = new Taxi("K5", "감홍색", "기아");
		System.out.println("t2 >> " + t2.toString() + "  기본요금 : "  + t2.basicPrice);

		int km = 20;
		t2.initPrice();
		System.out.println(t2 + "를 타고 구디에서 강남까지 " + 
			km + "km이동!!!");
		int price = t2.calcPrice(km);
		t2.sumPrice();
		System.out.println("요금 : " + price + "원");
		System.out.println("누적 수익 : " + t2.totalPrice + "원");

		km = 20;
		t2.initPrice();
		System.out.println(t2 + "를 타고 강남에서 구디까지 " + 
			km + "km이동!!!");
		price = t2.calcPrice(km);
		t2.sumPrice();
		System.out.println("요금 : " + price + "원");
		System.out.println("누적 수익 : " + t2.totalPrice + "원");

		int upDown = 50;
		System.out.println("t2의 속도를 " + upDown + "만큰 가속!!!");
		int speed = t2.speedUp(upDown);
		System.out.println("t2의 속도 : " + speed + "  " + t2.speed);

		upDown = 250;
		System.out.println("t2의 속도를 " + upDown + "만큰 가속!!!");
		speed = t2.speedUp(upDown);
		System.out.println("t2의 속도 : " + speed + "  " + t2.speed);

		Taxi t3 = new Taxi("K5", "감홍색", "기아");
		System.out.println(t2 + "    " + t3);
		System.out.println(t2.hashCode() + "    " + t3.hashCode());
		if(t2 == t3)//==(비교연산자)는 기본DT일 경우에 값을 비교만 참조형DT일 경우는 주소값을 비교.
			System.out.println("t2와 t3는 주소값이 같은차이다.");
		else
			System.out.println("t2와 t3는 주소값이 다른차이다.");

		if(t2.equals(t3))
			System.out.println("t2와 t3는 차이름이 같은차이다.");
		else
			System.out.println("t2와 t3는 차이름이 다른차이다.");

	}
}
