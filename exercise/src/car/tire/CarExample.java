package car.tire;

public class CarExample {
	public static void main(String[] args) {

		Car car = new Car();

		for (int i = 1; i <= 5; i++) {
			int problemlocation = car.run();

			switch (problemlocation) {
			case 1:
				System.out.println("앞왼쪽 HanKookTire로 교체");
				car.frontLeftTire = new HankookTire("앞왼쪽", 15);// 필드에 객체를 생성해서 대입한다고?
				break;
			case 2:
				System.out.println("앞오른쪽 KumhoTire로 교체");
				car.frontLeftTire = new KumhoTire("앞왼쪽", 13);
				break;
			case 3:
				System.out.println("뒤왼쪽 HanKookTire로 교체");
				car.frontLeftTire = new HankookTire("앞왼쪽", 14);
				break;
			case 4:
				System.out.println("뒤오른쪽 KumhoTire로 교체");
				car.frontLeftTire = new KumhoTire("앞왼쪽", 17);
				break;
			}
			System.out.println("---------------------------------------------");

		}
	}
}
