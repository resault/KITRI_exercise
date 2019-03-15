public class OperTest2 {
	public static void main(String[] args)	{
		//산술연산자 우선순위 +,-,/,*
		
		int num1 = 13;
		int num2 = 5;
		int num3 = num1 + num2;

		//+
		System.out.println(num1 + " + " + num2 + " = " + num3);
		System.out.println(num1 + " + " + num2 + " = " + num2 + num3);//문자열에 숫자형을 더하게 되므로 산술연산이 안됨
		System.out.println(num1 + " + " + num2 + " = " + (num2 + num3));

		//*
		System.out.println(num1 + " * " + num2 + " = " + num1 * num2);
	}
}
