public class Car {
	//field : carname, color, maker,speed
	String carName;
	String color;
	String maker;
	int speed;

	//constructor
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

	//method : speedUp, speedDown, stop
	public int speedUpDown(int speed) {
		this.speed += speed;
		if(this.speed <0)
			stop();
		return this.speed;
	}

	public void stop() {
		speed = 0;
	}


	public void speedInfo(int speed) {
		speedUpDown(speed);
		String variation;
		if(speed < 0)
			variation = "����";
		else
			variation = "����";
		System.out.println(carName + "�� �ӵ��� "+Math.abs(speed)+ variation+"!!!");
		System.out.println(carName+ "�� �ӵ�: " + this.speed);
	}

	//toString overriding
	@Override
	public String toString() {
		return maker + "���� ���� " + color + " " + carName;
	}
	
	//equal overriding
}
