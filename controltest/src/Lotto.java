public class Lotto {// 45개 숫자, 6자리, 5게임
	public static void main(String[] args)	{

		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int num4 = 0;
		int num5 = 0;
		int num6 = 0;


		for(int gamecount=1;gamecount<6;gamecount++) {
			num1 = (int) (Math.random() * 45 + 1);
			do{
				num2 = (int) (Math.random() * 45 + 1);
			}	while(num1 == num2);


			do{
				num3 = (int) (Math.random() * 45 + 1);
			}	while(num1 == num3 || num2 == num3);


			do{
				num4 = (int) (Math.random() * 45 + 1);
			}	while(num1 == num4 || num2 == num4 || num3 == num4);


			do{
				num5 = (int) (Math.random() * 45 + 1);
			}	while(num1 == num5 || num2 == num5 || num3 == num5 || num4 == num5);
			

			do{
				num6 = (int) (Math.random() * 45 + 1);
			}	while(num1 == num6 || num2 == num6 || num3 == num6 || num4 == num6 || num5 == num6);


			System.out.println(gamecount +"당첨 번호 : " + num1 + " " + num2 + " " + num3 + " " + num4 + " " + num5 + " " + num6);
		}
	}
}
