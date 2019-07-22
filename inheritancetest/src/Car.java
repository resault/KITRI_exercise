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
		//super();�� �����Ǿ� ����
		this.carName = carName;
		this.color = color;
		this.maker = maker;
	}


	public int speedUp(int a) {
		this.speed += a;
		return this.speed;
	}


	public int speedDown(int speed) { 
		this.speed -= speed;
		if(this.speed < 0)
			stop();
		return this.speed;
	}


	public void stop()	{
		speed = 0;	
	}

	/*
	public String info() {
		return maker + "���� ���� " + color + " " + carName ;
	}
	*/

	@Override
	public String toString() {//object class�� method�� override
		return maker +"���� ���� " + color + " " + carName ;
	}

}
