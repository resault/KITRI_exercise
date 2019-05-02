public class Lotto {
	public static void main(String[] args) {
		int gameCount = 5;

		int num1 = (int) (Math.random() * 3) + 1;
		int num2 = 0;
		int num3 = 0;
		do {
			num2 = (int) (Math.random() * 3) + 1;
		}while (num1 == num2);
		do {
			num3 = (int) (Math.random() * 3) + 1;
		}while (num1 == num3 || num2 == num3);
		System.out.println("금주 당첨 번호 : ");
		//1. 23 12 4 17 25 19
		//
	}
}
