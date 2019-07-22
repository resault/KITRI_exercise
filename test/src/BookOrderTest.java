public class BookOrderTest {
	public static void main(String[] args)	{
		int priceJava = 24000;
		int priceJquery = 21000;
		int priceOracle = 19000;
		int priceSpring = 35000;
		int sumPrice;
		int result;

		System.out.println("===== 도서 구입 목록 =====");

		sumPrice = priceJava + priceJquery + priceOracle + priceSpring;
		result = (int)(sumPrice*0.85);

		System.out.println("JAVA : " + priceJava);
		System.out.println("JQuery : " + priceJquery);
		System.out.println("오라클 : " + priceOracle);
		System.out.println("스프링 : " + priceSpring);
		System.out.println("--------------------------");
		System.out.println("주문 총금액 : "+sumPrice+"원");
		System.out.println("할인후 결제 금액 : " +result+"원");
	}
}
