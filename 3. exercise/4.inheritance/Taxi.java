/*
1. 요금
  기본요금(basicPrice)
    일반 : 3800
	심야 : 5000
  누적요금(totalPrice)
  요금(price)
    일반 : 100/km
	심야 : 150/km
2. 요금 계산(calcPrice())
3. 심야할증 : 0시 ~ 6시
*/
import java.util.*;
public class Taxi extends Car {

	//field
	int basicPrice;
	int totalPrice;
	int price;
	int pricePerKm;


	//constructor
	public Taxi() {
		super();
	}

	public Taxi(String carName, String color, String maker) {
		/*
		this.carName = carName;
		this.color = color;
		this.maker = maker;
		*/
		super(carName, color, maker);
	}

	//method
	public void initPrice() {
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);

		if(hour < 6) {
			basicPrice = 5000;
			pricePerKm = 150;
		} else {
			basicPrice = 3800;
			pricePerKm = 100;
		}
	}

	public int calcPrice(int km) {
		price = basicPrice;
		for(int i=0;i<km;i++)
			price += pricePerKm;
		return price;
	}

	public void sumPrice(int km) {
		totalPrice += calcPrice(km);
		System.out.println("요금 : "+price+"원\n누적 수익 : "+totalPrice+"원");
		price = 0;
		basicPrice = 0;
		pricePerKm = 0;
	}

	//overriding
	@Override
	public int speedUpDown(int speed) {
		speed= super.speedUpDown(speed);
		if(speed > 150)
			this.speed = 150;
		return this.speed;
	}
	@Override
	public String toString() {
		//return maker + "에서 만든 " + color + " " + carName+ " 택시";
		return super.toString() + " 택시";
	}
}
