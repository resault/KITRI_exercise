package com.kitri.hello2;

public class HelloMain {

	public static void main(String[] args) {
		HelloService helloService = new HelloServiceKor();		
//		HelloService helloService = new HelloServiceEng();
		
		String msg = helloService.hello("안효인");
		
		System.out.println(msg);
	}
	
}
