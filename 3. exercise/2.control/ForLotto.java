/*
* Lotto
1 - 3까지의 서로다른 난수 3개 발생.
*/
public class ForLotto {
	public static void main(String[] args) {
		int num1 = (int)(Math.random() * 3) + 1;
		int num2;
		int num3;
		
		for(;;) {
			num2 = (int)(Math.random() * 3) + 1;
			if(num1 == num2) 
				num2 = (int)(Math.random() * 3) + 1;//난수 발생 코드가 중복되므로, 조건을 !=로 실행문을 break;로 주는 것이 효율적임
			else 
				break;
		}

		for(;;) {
			num3 = (int) (Math.random() * 3) + 1;
			if(num1 == num3 || num2 == num3) 
				num3 = (int) (Math.random() * 3) + 1;
			else
				break;
		
		}

		System.out.println(num1 + ", " + num2 + ", " + num3);


	}
}
