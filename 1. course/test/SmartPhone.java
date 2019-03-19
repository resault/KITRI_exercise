public class SmartPhone {
	//field
	private String maker;
	private String name;
	private int price;
	private int discountRate;

	//constructor
	public SmartPhone(String maker, String name, int price) {
		this(maker, name, price, 0);
	}

	public SmartPhone(String maker, String name, int price, int discountRate) {
		this.maker = maker;
		this.name = name;
		this.price = price;
		this.discountRate = discountRate;
	}

	//method
	public int calculateDiscount() {
		return (int)(price * (100-discountRate) / 100);//answer참고.. double?!
	}

	public void info() {//toString override 해볼 것
		System.out.println(name + " ["+ maker + "] ");
		System.out.println("가격 : " + price);
		if (discountRate != 0)	{
			System.out.println("할인가격 : " + calculateDiscount());
		}
		System.out.println("-------------------");
	}

}
