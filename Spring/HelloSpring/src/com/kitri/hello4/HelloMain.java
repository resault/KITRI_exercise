package com.kitri.hello4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kitri.hello4.HelloService;

public class HelloMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(HelloServiceFactory.class);
		HelloService helloService = context.getBean("helloservice", HelloService.class);
		
		String msg = helloService.hello("안효인");
		
		System.out.println(msg);
		
		
//		HelloService h1 = context.getBean("hs", HelloService.class);
//		HelloService h2 = context.getBean("hs", HelloService.class);
//		
//		System.out.println(h1 + "    " + h2);
		
	}
	
}