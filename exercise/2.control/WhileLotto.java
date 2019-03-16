/*
1~3 사이의 서로 다른 숫자
*/
public class WhileLotto {
	public static void main(String[] args) {
		int num1 = (int) (Math.random() * 3) +1;
		int num2;
		int num3;

		for(;;) {
			num2 = (int)(Math.random() * 3) + 1;
			if(num1 != num2)
				break;
		}

		for(;;) {
			num3 = (int)(Math.random() * 3) +1;
			if(num1 != num3 && num2 != num3)
				break;
		}

		System.out.println(num1 + ", " + num2 + ", " + num3);
	}
}
