public class TaxiGuest {
	public static void main(String[] args)	{
	
		Taxi t1 = new Taxi();
		System.out.println("t1 >>" + t1.toString());//이건 defaul 생성자가 상속된게 아니라, super();를 통해 호출되고, infor 메소드를 통해 name color등을 출력한거임


		Taxi t2 = new Taxi("K5", "감홍색", "기아");
		System.out.println("t2 >> " + t2.toString());
/*
		int km = 20;
		System.out.println(t2 + "를 타고 구디에서 강남까지 " + km + "km이동!!!");
		int price = t2.calcPrice(km);
		System.out.println("요금 : " + price + "원");

		km = 20;
		System.out.println(t2 + "를 타고 강남에서 구디까지 " + km + "km이동!!!");
		price = t2.calcPrice(km);
		System.out.println("요금 : " + price + "원");
		System.out.println("누적수입 : " + t2.totalPrice + "원");
		

		km = 5;
		System.out.println(t2 + "를 타고 구디에서 강남까지 " + km + "km이동!!!");
		t2.initPrice();
		price = t2.calcPrice(km);
		int totalPrice = t2.sumPrice();
		System.out.println("요금 : " + price + "원");
		System.out.println("누적수입 : " + totalPrice + "원");

		System.out.println();
	
		km = 20;
		System.out.println(t2 + "를 타고 강남에서 구디까지 " + km + "km이동!!!");
		t2.initPrice();
		price = t2.calcPrice(km);
		totalPrice = t2.sumPrice();
		System.out.println("요금 : " + price + "원");
		System.out.println("누적수입 : " + totalPrice + "원");
	*/
		int upDown = 50;
		System.out.println("t2의 속도를 " + upDown +"만큼 가속!!");
		int speed = t2.speedUp(upDown);
		System.out.println("t2의 속도 : " + speed +" " + t2.speed);

		upDown = 250;
		System.out.println("t2의 속도를 " + upDown +"만큼 가속!!");
		speed = t2.speedUp(upDown);
		System.out.println("t2의 속도 : " + speed + " "+t2.speed);
/*
//toString() : 숫자형을 문자열로 return
		System.out.println(t1.toString() + "       " + t2);//toString()이라는 object의 method가 자동으로 호출 되어 문자열로 변환되어 출력된 거임
		System.out.println(t1.toString() + "       " + t2.toString());//toString()은 생략 가능

*/

//hashcode() : 주소값을 반환
		Taxi t3 = new Taxi("K5", "감홍색", "기아");
		System.out.println(t2 + "       " + t3);//?? 이거왜 주소값이 아니라 내용이 나옴?>> 이거 toString의 자체기능임. 얘는 문자열이랑 결합만 하면 딱히 명시 안해도 나옴
		System.out.println(t2.hashCode() + "       " + t3.hashCode());
		
		if(t2 == t3) //비교연산자는 기본DT일 경우에 값을 비교하지만, 참조형DT일 경우는 주소값을 비교함
			System.out.println("t2와 t3는 주소값이 같은차이다.");
		else
			System.out.println("t2와 t3는 주소값이 다른차이다.");

//equals()	: 주소값을 비교
//equals()를 overide해서 이름을 비교
		if(t2.equals(t3))
			System.out.println("t2와 t3는 차이름이 같은차이다.");
		else
			System.out.println("t2와 t3는 차이름이 다른차이다.");
		
	}
}
