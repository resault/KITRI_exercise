public class SmartPhone {
	
	private String maker;
	private String name;
	private int price;
	private int discountRate;

	public SmartPhone(String maker, String name, int price) {
		super();
		this.maker = maker;
		this.name = name;
		this.price = price;
	}

	public SmartPhone(String maker, String name, int price, int discountRate) {
		super();
		this.maker = maker;
		this.name = name;
		this.price = price;
		this.discountRate = discountRate;
	}

	public int calculateDiscount() {
		return (int) (price * (1.0 - (double)discountRate/100));
	}

	@Override
	public String toString() {
		String str = name + " [" + maker + "]\n가격 : " + price;
		if(discountRate != 0)
			str += "\n할인가격 : " + calculateDiscount();
		str += "\n------------------"; 
		return str;
	}

}
