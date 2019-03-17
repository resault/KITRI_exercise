public class Car {
	//field : carname, color, maker,speed
	String carName;
	String color;
	String maker;
	int speed;

	//constructor
	public Car() {//constuctor의 이름은 class 이름과 같아야 함
		this("쏘나타", "검정색", "현대");//내부 constructor 호출
	}

	public Car(String carName, String color, String maker) {//constructor의 overloading
		this.carName = carName;//내부 field 참조
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
		System.out.println("1. 차이름: " + carName + " 색상: " + color + " 제조사: " + maker);
	}

	public void speedInfo(int cnt) {
		speedUpDown(cnt);
		String variation;
		if(cnt < 0)
			variation = "감소";
		else
			variation = "증가";
		System.out.println(Math.abs(cnt) + "회 "+ variation+" 후 " + carName + "의 속도: "+ speed);
	}
}
