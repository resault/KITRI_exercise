public class BookOrderTest {
	public static void main(String[] args)	{
		int priceJava = 24000;
		int priceJquery = 21000;
		int priceOracle = 19000;
		int priceSpring = 35000;
		int sumPrice;
		int result;

		System.out.println("===== ���� ���� ��� =====");

		sumPrice = priceJava + priceJquery + priceOracle + priceSpring;
		result = (int)(sumPrice*0.85);

		System.out.println("JAVA : " + priceJava);
		System.out.println("JQuery : " + priceJquery);
		System.out.println("����Ŭ : " + priceOracle);
		System.out.println("������ : " + priceSpring);
		System.out.println("--------------------------");
		System.out.println("�ֹ� �ѱݾ� : "+sumPrice+"��");
		System.out.println("������ ���� �ݾ� : " +result+"��");
	}
}
