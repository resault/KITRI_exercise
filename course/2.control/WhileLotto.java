// while문으로 lotto >>> 다시 해볼 것
public class WhileLotto {
	public static void main(String[] args)	{
		int num1 = (int) (Math.random() * 3 + 1);
		int num2 = (int) (Math.random() * 3 + 1);
		int num3 = (int) (Math.random() * 3 + 1);

		while(num1 == num2 || num1 == num3 || num2 == num3) {
			num1 = (int) (Math.random() * 3 + 1);
			num2 = (int) (Math.random() * 3 + 1);
			num3 = (int) (Math.random() * 3 + 1);
		}


		System.out.println("금주 당첨 번호 : " + num1 + " " + num2 + " " + num3);

	}
}
