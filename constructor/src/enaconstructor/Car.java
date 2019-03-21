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
		System.out.println("1. 차이름: " + carName + " 색상: " + color + " 제조사: " + maker);
	}

	public void speedInfo(int cnt) {
		speedUpDown(cnt);
		String variation;
		if(cnt < 0)
			variation = "감소";
		else
			variation = "증가";
		System.out.println(carName + "의 속도를 "+Math.abs(cnt)+ variation+"!!!");
		System.out.println(carName+ "의 속도: " + speed);
	}
}
