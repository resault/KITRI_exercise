/*
1~45 사이의 서로 다른 6개의 숫자
6게임
*/
public class Lotto {
	public static void main(String[] args) {
		int num1 = (int) (Math.random() * 45) +1;
		int num2;
		int num3;
		int num4;
		int num5;
		int num6;
		
		for(int i=0;i<6;i++) {
			do{
				num2 = (int) (Math.random() * 45) +1;
			} while(num1 == num2);

			do{
				num3 = (int)(Math.random() * 45) +1;
			} while(num1 == num3 || num2 == num3);

			do{
				num4 = (int)(Math.random() * 45) +1;
			} while(num1 == num4 || num2 == num4 || num3 == num4);

			do{
				num5 = (int)(Math.random() * 45) +1;
			} while(num1 == num5 || num2 == num5 || num3 == num5 || num4 == num5);

			do{
				num6 = (int)(Math.random() * 45) +1;
			} while(num1 == num6 || num2 == num6 || num3 == num6 || num4 == num6 || num5 == num6);
			
			System.out.println("\n금주의 당첨 번호");
			System.out.println(num1 + ", " + num2 + ", " + num3 + ", " + num4 + ", " + num5 + ", " + num6);
		}
	}
}
