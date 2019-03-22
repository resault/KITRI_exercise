/*
1. 요금
	기본요금(basicPrice)
		- 일반: 3800, 심야: 5000
	요금합(totalPrice)
		- 누적요금
	요금(price)
		- 일반: 100/km, 심야: 150/km
2. 요금 계산(calcPrice())
3. 심야할증 : 0시 ~ 6시
*/
import java.util.*;

public class Taxi extends Car {

	int basicPrice;
	int totalPrice; 
	int price;
	int dprice;
	//int speed;

	public Taxi() {
		//super();가 생략되어 있음 - default 생성자를 호출함 ∴상위class에 default생성자가 없으면 에러 발생함
		basicPrice = 3800;
		dprice = 100;
	}

	public Taxi(String carName, String color, String maker) {
		/*
		super();--->생략되어 있음
		this.carName = carName;
		this.color = color;
		this.maker = maker; >> 결국, 상위class를 호출해서 값을 받아오고, 또 인자값을 대입하므로 비효율적임
		*/

		super(carName, color, maker);
		basicPrice = 3800;
	}



	//method

	public void initPrice(int km) {
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		
		if (hour >= 0 && hour < 6) {
			basicPrice = 5000;
			dprice = 150;
			System.out.println("심야할증이 적용됩니다.");
		}
		this.calcPrice(km);
		price = basicPrice;
	}


	public int calcPrice(int km ) {
		for (int i=0;i<km;i++)	{
			price += dprice;
		}
		return price;
	}


	public int sumPrice() {
		totalPrice += price;
		return totalPrice;
	}


	/*
	@override//method의 이름이 달라 에러 발생함
	int speedup(int speed) { //method의 이름이 다르기 때문에 overriding 되지 않음
		this.speed += speed;
		if(this.speed > 150)
			this.speed = 150;
		return this.speed;
	
	
	@Override
	int speedUp(int speed) {//상위class보다 좁은 의미의 접근제어자는 사용할 수 없음
		this.speed += speed;
		if(this.speed > 150)
			this.speed = 150;
		return this.speed;
	
	
	@Override
	public int speedUp(int speed) {
		this.speed += speed;
		if(this.speed > 150)
			this.speed = 150;
		return this.speed;
	}
	

	@Override
	public int speedUp(int speed) {
		speedUp(speed);//taxi class의 speedUp이 호출되어 무한루프 돌다가 꺼져버림
		if(this.speed > 150)
			this.speed = 150;
		return this.speed;
	}
	

	@Override
	public int speedUp(int speed) {
		speed = super.speedUp(speed);//int speed를 인자로 하여 상위class의 speedUp method 호출하고, 반환값을 대입함
		if(this.speed > 150)
			this.speed = 150;
		return this.speed;
	}

	
	@Override
	public int speedUp(int speed) {
		speed = super.speedUp(speed);
		if(speed > 150)
			speed = 150;//필드값을 인자로 받아와서 지역변수로 조건 비교 한 후에, 지역변수에 대입해버림
		return speed;
	}


	*/

	@Override
	public int speedUp(int speed) {
		speed = super.speedUp(speed);
		if(speed > 150)
			this.speed = 150;
		return this.speed;
	}

/*	
	@Override
	public String toString() {
	return maker + "에서 만든 " + color + " " + carName + "택시";
	}
	
*/
	@Override
	public String toString() {
		return super.toString() + "택시";
	}
/*
	@Override
	public boolean equals(Object obj) { //이거.. 인자값 무엇..?
		Car car = obj;//상위를 하위에 대입하려고 해서 에러 발생
		if(carName == car.carName)
		return true;
	}

*/

	@Override
	public boolean equals(Object obj) { //이거.. 인자값 무엇..?
		Car car = (Car) obj;//taxiguest에서 택시를 받아오기때문에 car로 강제형변환 가능
		//if(carName == car.carName)//""일 경우는 true, new String("")일 경우는 false
		if(carName.equals(car.carName))
			return true;
		return false;	//String은 object라서 == 비교 안되는데.. 되고 있음... String에서 equlas override 이거.. ==과 equals 확인
	}

// 두 객체를 비교할 때는, == 쓰지 말고 equals 사용!


/*
	//Car car = new Car();
	Car car = new Taxi();
	Taxi t = new Taxi();
	t = (Taxi)car;
*/





}

/*
- 시간을 얻어오는 코드
Calendar calendar = Calendar.getInstance();
int hour = calendar.get(Calendar.HOUR_OF_DAY);
*/