/*
* Lotto
1 - 3������ ���δٸ� ���� 3�� �߻�.
*/
public class ForLotto {
	public static void main(String[] args) {
		int num1 = (int)(Math.random() * 3) + 1;
		int num2;
		int num3;
		
		for(;;) {
			num2 = (int)(Math.random() * 3) + 1;
			if(num1 == num2) 
				num2 = (int)(Math.random() * 3) + 1;//���� �߻� �ڵ尡 �ߺ��ǹǷ�, ������ !=�� ���๮�� break;�� �ִ� ���� ȿ������
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
