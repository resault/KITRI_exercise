public class OperTest1 
{
	public static void main(String[] args) 
	{
		int x = 10;
		System.out.println(x);
		System.out.println(x++);
		System.out.println(--x);
		System.out.println(x++);
		System.out.println(++x);
		System.out.println(x--);
		System.out.println(--x);
		System.out.println(x++);
		System.out.println(x);

		char c = 'a';
		System.out.println("c == " + c);
		System.out.println("(int)c == " + (int)c);// 강제형변환

		int y = c;// 자동형변환
		System.out.println("y == " + y);

		c = (char)y;// 강제형변환
		System.out.println("c == " + c);

		//boolean b = true;
		//int z = b;//error

		int z = 30;
		double d = z;
		//z = d;//error
		z = (int) d;
	}
}
