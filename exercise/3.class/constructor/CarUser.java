public class CarUser {
	public static void main(String[] args) {

		Car car1 = new Car();

		//1. 차이름 : K5 색상 : 흰색 제조사 : 기아
		Car car2 = new Car("K5", "흰색", "기아");
		car2.info();

		//속도를 85 증가!!!
		car2.speedInfo(85);

		System.out.println(car1 + "    " + car2);
	}
}
