public class Car {

	String carName;
	String color;
	String maker;
	int speed;

	//생성자를 하나라도 만들면 default 생성자는 사라짐. 따라서 '모든 생성자는 default생성자가 있다'라는 명제는 faulse
	public Car() {	//객체를 생성할 때, 객체를 초기화 시킴 (default생성자는 class를 메모리에 올리는 역할만 함)
		/*
		carName = "쏘나타";
		color = "검정색";
		maker = "현대";
		*/
		
		this("쏘나타", "검정색", "현대");
	}

	public Car(String color) {
		/*
		carName = "쏘나타";
		this.color = color;
		maker = "현대";
		*/
		this("쏘나타", color, "현대");
	}

	public Car(String carName, String color) {
		/*
		this.carName = carName;
		this.color = color;
		maker = "현대";
		*/
		this(carName, color, "현대");
	}

	public Car(String carName, String color, String maker) {
		this.carName = carName;
		this.color = color;
		this.maker = maker;
	}

	public void speedUp() {//void의 경우, return을 생략하거나 return; 이렇게 쓰면 됨
		speed += 10;
	}

	public int speedUp(int speed) { //return type을 지정하고 메소드 안에서 return하지 않으면 에러 발생함
		this.speed += speed; // !! this를 사용하지 않았을 경우 생각해볼것
		return this.speed;
	}

	public void speedDown() {
		speed -= 10;
		if(speed < 0)
			stop();
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

	
	public String info() {
	return "차이름 : " + carName + " 색상 : " + color + " 제조사 : " + maker ;
	}

}
