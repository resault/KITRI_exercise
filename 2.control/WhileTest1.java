public class WhileTest1 {
	public static void main(String[] args)	{

		System.out.println("1 - 10���� ���.");
		int i = 1;
		while ( i < 10) {
			System.out.println(++i);
		}	


		System.out.println("1 - 10���� ���� �߻�.");
		boolean flag = true;
		int a=0;
		while (flag) {
			int number = (int) (Math.random() * 11);//0 - 11
			a++ ;
			if (number != 0){
				System.out.println("number == " + number);	
			} else {
				System.out.println("0�� �߻�(" + a +"��°)�Ǿ� ���α׷� ����!!!");
				flag = false;
			}
			
		}
		
	}
}
