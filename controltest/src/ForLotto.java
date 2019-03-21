/*
* Lotto
1 ~ 3까지의 서로 다른 난수 3개 발생

*/

public class ForLotto {
	public static void main(String[] args)	{
		//int num1, num2, num3;
		/*
		int a = 1;
		int num1=0, num2=0, num3=0;

		for(;a!=0;) {
			num1 = (int) (Math.random() * 3 + 1);
			num2 = (int) (Math.random() * 3 + 1);
			num3 = (int) (Math.random() * 3 + 1);
			if (num1 !=num2 && num2 !=num3 && num1 !=num3) {
				a=0;
			}
		}
		*/
		
		/*
		int num1, num2, num3;
		for(;;) {
			num1 = (int) (Math.random() * 3 + 1);
			num2 = (int) (Math.random() * 3 + 1);
			num3 = (int) (Math.random() * 3 + 1);
			if (num1 !=num2 && num2 !=num3 && num1 !=num3) {
				break;
			}
		}
		*/

		int num1 = (int) (Math.random() * 3 + 1);	//but, 보통 무한루프 쓸 때는 for문 사용X
		int num2 = 0;
		int num3 = 0;

		for(;;) {
			num2 = (int) (Math.random() * 3 + 1);
			if (num1 !=num2) {
				break;
			}
		}

		for(;;) {
			num3 = (int) (Math.random() * 3 + 1);
			if (num1 !=num3) {
				break;
			}
		}
		System.out.println("금주 당첨 번호 : " + num1 + " " + num2 + " " + num3);
	}
}
