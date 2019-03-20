public class Car {
	//field : carname, color, maker,speed
	String carName;
	String color;
	String maker;
	int speed;

	//constructor
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
			variation = "감소";
		else
			variation = "증가";
		System.out.println(carName + "의 속도를 "+Math.abs(speed)+ variation+"!!!");
		System.out.println(carName+ "의 속도: " + this.speed);
	}

	//toString overriding
	@Override
	public String toString() {
		return maker + "에서 만든 " + color + " " + carName;
	}
	
	//equal overriding
}
