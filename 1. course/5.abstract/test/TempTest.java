public class TempTest {
	public static void main(String[] args)	{
		

		Temp book1 = new Temp("JAVA", 24000);
		Temp book2 = new Temp("JQuery", 21000);
		Temp book3 = new Temp("����Ŭ", 19000);
		Temp book4 = new Temp("������", 35000);
		
		int sumPrice = book1.price +book2.price +book3.price +book4.price;
		int discount = (int)(sumPrice*0.85);

		System.out.println("===== ���� ���� ��� =====");
		book1.info();
		book2.info();
		book3.info();
		book4.info();
		System.out.println("--------------------------");
		System.out.println("�߹� �ѱݾ� : "+sumPrice+"��");
		System.out.println("������ ���� �ݾ� : "+discount+"��");
	}
}
