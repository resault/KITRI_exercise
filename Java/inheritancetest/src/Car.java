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
		//super();가 생략되어 있음
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
		return maker + "에서 만든 " + color + " " + carName ;
	}
	*/

	@Override
	public String toString() {//object class의 method를 override
		return maker +"에서 만든 " + color + " " + carName ;
	}

}
