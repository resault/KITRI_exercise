package car.tire;
/*
1. field
- frontLeftTire
- frontRightTire
- backLeftTire
- backRightTire

2. method
- int run()
- void stop() (��ũ)
*/
public class Car {

	Tire frontLeftTire = new Tire("�տ���", 6);
	Tire frontRightTire = new Tire("�տ�����", 2);
	Tire backLeftTire = new Tire("�ڿ���", 3);
	Tire backRightTire = new Tire("�ڿ�����", 4);

	
	public int run() {
		System.out.println("�ڵ����� �޸��ϴ�.");
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
		System.out.println("�ڵ����� ����ϴ�.");
	}
	
}
