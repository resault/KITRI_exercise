public class Car {

	String carName;
	String color;
	String maker;
	int speed;

	//public Car() {} >> default 생성자

	public void speedUp() {
		speed += 10;
	}

	public void speedDown() {
		speed -= 10;
		if(speed < 0)
			stop();//같은 클래스 안의 메소드를 호출할 때에는 메소드 앞에 "객체." 생략 가능 >> 이거 생략가능인가 아님 생략해야함인가?
	}

	public void stop() {
		speed = 0;
	}
}
