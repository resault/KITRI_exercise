public class TempTest {
	public static void main(String[] args)	{
		

		Temp book1 = new Temp("JAVA", 24000);
		Temp book2 = new Temp("JQuery", 21000);
		Temp book3 = new Temp("오라클", 19000);
		Temp book4 = new Temp("스프링", 35000);
		
		int sumPrice = book1.price +book2.price +book3.price +book4.price;
		int discount = (int)(sumPrice*0.85);

		System.out.println("===== 도서 구입 목록 =====");
		book1.info();
		book2.info();
		book3.info();
		book4.info();
		System.out.println("--------------------------");
		System.out.println("추문 총금액 : "+sumPrice+"원");
		System.out.println("할인후 결제 금액 : "+discount+"원");
	}
}
