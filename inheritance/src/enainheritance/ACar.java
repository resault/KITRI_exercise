public class Car {
	String carName;
	String color;
	String maker;
	int speed;

	public Car() {
		this("쏘나타", "검정색", "현대");
	}

	public Car(String color) {
		this("쏘나타", color, "현대");
	}

	public Car(String carName, String color) {
		this(carName, color, "현대");
	}

	public Car(String carName, String color, String maker) {
		this.carName = carName;
		this.color = color;
		this.maker = maker;
	}

	int speedUp(int speed) {
		this.speed += speed;
		return this.speed;
	}

	int speedDown(int speed) {
		this.speed -= speed;
		if(this.speed < 0)
			stop();
		return this.speed;
	}

	void stop() {
		speed = 0;
	}

	@Override
	public String toString() {
		return maker + "에서 만든 " + color + " " + carName;
	}

	@Override
	public boolean equals(Object obj) {
		Car car = (Car) obj;
		//if(carName == car.carName)//""일 경우는 true, new String("")일 경우는 false.
		if(carName.equals(car.carName))
			return true;
		return false;
	}
}
