/*
* 备备窜1
2*1=2	....	9*1=9
...
2*9=18

* 备备窜2
2*1=2	....	2*9=18
...
9*1=9	....	9*9=81
*/
public class Gugudan {
	public static void main(String[] args)	{

		
		System.out.print("***备备窜1***");
		for(int i=1;i<10;i++) {
			System.out.println();
			for(int dan = 2;dan<10;dan++)	{
				int result = dan * i;
				System.out.print(dan + " * " + i + " = " + result + "  ");
			}
		}



		System.out.print("\n***备备窜2***");
		for(int dan=2;dan<10;dan++) {
			System.out.println();
			for(int i=1;i<10;i++) {
				int result = dan * i;
				System.out.print(dan + " * " + i + " = " + result + "  ");
			}
		}
	}
}
