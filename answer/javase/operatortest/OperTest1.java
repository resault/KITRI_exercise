public class OperTest1 
{
	public static void main(String[] args) 
	{
		int x = 126;
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
		System.out.println("(int)c == " + (int)c);

		int y = c;//�ڵ�����ȯ
		System.out.println("y == " + y);

		c = (char)y;//��������ȯ
		System.out.println("c == " + c);

		//boolean b = true;
		//int z = b;//error

		int z = 30;
		double d = z;
		//z = d;//error
		z = (int) d;

	}
}
