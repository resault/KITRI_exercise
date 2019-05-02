public class Car {
	String carName;
	String color;
	String maker;
	int speed;

	public Car() {
		this("�Ÿ", "������", "����");
	}

	public Car(String color) {
		this("�Ÿ", color, "����");
	}

	public Car(String carName, String color) {
		this(carName, color, "����");
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
		return maker + "���� ���� " + color + " " + carName;
	}

	@Override
	public boolean equals(Object obj) {
		Car car = (Car) obj;
		//if(carName == car.carName)//""�� ���� true, new String("")�� ���� false.
		if(carName.equals(car.carName))
			return true;
		return false;
	}
}
