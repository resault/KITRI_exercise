public class WhileGugudan {
	public static void main(String[] args)	{
		System.out.println("***±¸±¸´Ü***");
		
		int i = 0;
		while(i<9) {
			i++;
			int dan = 1;
			System.out.println();
			while (dan<9) {
				dan++;
				int result = dan * i;
				System.out.print(dan + " * " + i + " = " + result + "  ");
			}
		}
	}
}
