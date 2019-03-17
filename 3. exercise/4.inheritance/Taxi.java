/*
1. ���
  �⺻���(basicPrice)
    �Ϲ� : 3800
	�ɾ� : 5000
  �������(totalPrice)
  ���(price)
    �Ϲ� : 100/km
	�ɾ� : 150/km
2. ��� ���(calcPrice())
3. �ɾ����� : 0�� ~ 6��
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
		System.out.println("��� : "+price+"��\n���� ���� : "+totalPrice+"��");
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
		//return maker + "���� ���� " + color + " " + carName+ " �ý�";
		return super.toString() + " �ý�";
	}
}
