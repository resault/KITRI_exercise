/*
*5´Ü
5*1=5
...
5*9=45
*/

public class ForTest2 {
	public static void main(String[] args)	{
		int dan = 5;

		System.out.println("* " + dan + "´Ü *");

		for(int i=1;i<10;i++){
			int result = dan * i;
			System.out.println(dan + " * " + i + " = " + result);	
		}
		
	}
}
