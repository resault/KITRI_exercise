/*
- double 개념 고려
- toString override
*/
public class SmartPhone {
	
	private String maker;
	private String name;
	private int price;
	private int discountRate;

	public SmartPhone(String maker, String name, int price) {
		this(maker, name, price)
	}

	public SmartPhone(String maker, String name, int price, int discountRate) {
		this.maker = maker;
		this.name = name;
		this.price = price;
		this.discountRate = discountRate;
	}

	public int calcDiscount() {

		return (int)(price * (1.0-(double)(discountRate/100)));
	}

	@Override
	public String toString(Object obj) {
		obj.name + " [" + obj.maker + "]" + '\n' + "가격 : " + obj.price;
	}
}
