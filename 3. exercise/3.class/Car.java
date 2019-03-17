public class Car {
	//field : carname, color, maker,speed
	String carName;
	String color;
	String maker;
	int speed;

	//constructor
	public Car() {//constuctor�� �̸��� class �̸��� ���ƾ� ��
		this("�Ÿ", "������", "����");//���� constructor ȣ��
	}

	public Car(String carName, String color, String maker) {//constructor�� overloading
		this.carName = carName;//���� field ����
		this.color = color;
		this.maker = maker;
	}

	//method : speedUp, speedDown, stop
	
	/*
	public int speedUp(int cnt) {
		speed += 10 * cnt;
		return speed;
	}

	public int speedDown(int cnt) {
		speed -= 10 * cnt;
		if(speed < 0)
			stop();
		return speed;
	}
	*/

	public int speedUpDown(int cnt) {
		speed += 10 * cnt;
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
		System.out.println(Math.abs(cnt) + "ȸ "+ variation+" �� " + carName + "�� �ӵ�: "+ speed);
	}
}
