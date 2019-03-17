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
	public int speedUpDown(int cnt) {
		speed += cnt;
		if(speed <0)
			stop();
		return speed;
	}

	public void stop() {
		speed = 0;
	}

	public void info() {
		System.out.println("1. ���̸�: " + carName + " ����: " + color + " ������: " + maker);
	}

	public void speedInfo(int cnt) {
		speedUpDown(cnt);
		String variation;
		if(cnt < 0)
			variation = "����";
		else
			variation = "����";
		System.out.println(carName + "�� �ӵ��� "+Math.abs(cnt)+ variation+"!!!");
		System.out.println(carName+ "�� �ӵ�: " + speed);
	}
}
