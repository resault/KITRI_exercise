package car.tire;
/*
1. field
- frontLeftTire
- frontRightTire
- backLeftTire
- backRightTire

2. method
- int run()
- void stop() (펑크)
*/
public class Car {

	Tire frontLeftTire = new Tire("앞왼쪽", 6);
	Tire frontRightTire = new Tire("앞오른쪽", 2);
	Tire backLeftTire = new Tire("뒤왼쪽", 3);
	Tire backRightTire = new Tire("뒤오른쪽", 4);

	
	public int run() {
		System.out.println("자동차가 달립니다.");
		if(frontLeftTire.roll()==false){
			stop();
			return 1;
		}
		if(frontRightTire.roll()==false){
			stop();
			return 2;
		}
		if(backLeftTire.roll()==false){
			stop();
			return 3;
		}
		if(backRightTire.roll()==false){
			stop();
			return 4;
		}
		return 0;
	}

	public void stop() {
		System.out.println("자동차가 멈춥니다.");
	}
	
}
