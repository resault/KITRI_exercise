package com.kitri.lang;

/*
Wrapper Class : 기본DT을 클래스화
기본DT		WrapperClass
boolean		Boolean
char		Character
byte		Byte
short		Short
int			Integer
long		Long
float		Float
double		Double
*/

public class WrapperClassTest {

	public static void main(String[] args) {
		
		//boooleanValue와 parseBoolean
		Boolean b1 = new Boolean(true);//"true"로 바꿔도 같음
		//b1 = new Boolean("ㅇㄴㅁㄹㅇㄴ");//Boolean은 문자열도 받을 수 있기 때문에 에러 안남
		boolean b2 = b1.booleanValue();

		boolean b3 = Boolean.getBoolean("true");
		b3 = Boolean.parseBoolean("true");
		
		if(b2)
			System.out.println("b2는 true다.");
		if(b3)
			System.out.println("b3는 true다.");
		
		
		//parseInt
		String s = "123";
		System.out.println(s + 4);//1234
//		s = "1 2 3 4 ";//컴파일 에러x, 런타임 에러o
//		Integer i = new Integer(s);
//		int x = i.intValue();
		int x = Integer.parseInt(s);
		System.out.println(x + 4);//123
			
		//parseDouble
		s = "123.45";
		double d = Double.parseDouble(s);
		System.out.println(d + 4);//127.45
		
		//autoboxing
		Integer i2 = new Integer(3);
		//unboxing
		int y = i2;
		//boxing
		Integer i3 = y;
		
		
	}
}
