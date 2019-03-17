public class CarUser {
	public static void main(String[] args)	{

		Car car1 = new Car();
		System.out.println(" 1. 차이름 : " + car1.carName + " 색상 : " + car1.color + " 제조사 : " + car1.maker);

		Car car2 = new Car("흰색");
		System.out.println(" 2. 차이름 : " + car2.carName + " 색상 : " + car2.color + " 제조사 : " + car2.maker);

		Car car3 = new Car("그랜저", "흰색");
		System.out.println(" 3. 차이름 : " + car3.carName + " 색상 : " + car3.color + " 제조사 : " + car3.maker);

		Car car4 = new Car("k5", "은색", "기아");
		System.out.println(" 4. 차이름 : " + car4.carName + " 색상 : " + car4.color + " 제조사 : " + car4.maker);

		System.out.println("car4의 속도를 3회 증가!!");
		for (int i=0;i<3;i++)
			car4.speedUp();
		System.out.println("car4속도 : " + car4.speed);
		
		System.out.println("car4의 속도를 85 증가!!");
		int speed = car4.speedUp(85);	//여기 변수의 speed는 사실 다른걸 해도 됨 다만 의미를 맞추기 위해서
		System.out.println("car4 계기판 속도 : " + speed);
		System.out.println("car4 실제 속도 : " + car4.speed);


		System.out.println(car1.info());	//반복되므로, info메소드 만들어버림
		System.out.println(car2.info());
		System.out.println(car3.info());
		System.out.println(car4.info());
	}
}
