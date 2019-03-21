public class Car {
	
	String carName;
	String color;
	String maker;
	int speed;

	//public Car() {}

	void speedUp() {
		speed += 10;
	}

	void speedDown() {
		speed -= 10;
		if(speed < 0)
			stop();
	}

	void stop() {
		speed = 0;
	}

}
