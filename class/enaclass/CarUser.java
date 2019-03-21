public class CarUser {
	public static void main(String[] args) {
		//1. 차이름 :  색상 :  제조사 : 
		Car car1 = new Car();
		car1.info();
		
		//1. 차이름 : 쏘나타 색상 : 검정색 제조사 : 현대
		/*car1.carName = "쏘나타";
		car1.color = "검정색";
		car1.maker = "현대";*/ //constructor에서 초기화
		car1.info();
		

		//car1의 속도를 2회 증가!!!
		//2회 증가 후  x의 속도 : x
		int cnt = 2;
		/*int speed = car1.speedUp(cnt);
		System.out.println(cnt + "회 증가 후 " + car1.carName + "의 속도: "+ speed);*/
		car1.speedInfo(cnt);

		//car1의 속도를 8회 증가!!!
		//8회 증가 후 x의 속도 : x
		cnt = 8;
		/*speed = car1.speedUp(cnt);
		System.out.println(cnt + "회 증가 후 " + car1.carName + "의 속도: " + speed);*/
		car1.speedInfo(cnt);

		//car1의 속도를 4회 감소!!!
		//4회 감소 후 x의 속도 : x
		cnt = -4;
		/*speed = car1.speedDown(cnt);
		System.out.println(cnt + "회 감소 후 " + car1.carName +"의 속도: "+ speed);*/
		car1.speedInfo(cnt);

		//car1의 속도를 10회 감소!!!
		//10회 감소 후 x의 속도 : x
		cnt = -10;
		/*speed = car1.speedDown(cnt);
		System.out.println(cnt + "회 감소 후 " + car1.carName + "의 속도: " + speed);*/
		car1.speedInfo(cnt);

		//2. 차이름 : K5 색상 : 흰색 제조사 : 기아
		Car car2 = new Car("K5", "흰색", "기아");
		//System.out.println("2. 차이름: " + car2.carName + " 색상: " + car2.color + " 제조사: " + car2.maker);
		car2.info();


	}
}
