package com.kitri.hello3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloMain {

	public static void main(String[] args) {
//		HelloService helloService = new HelloServiceKor();		
//		HelloService helloService = new HelloServiceEng();
		
//		spring 2.x
//		Resource resource = new ClassPathResource("com/kitri/hello3/applicationContext.xml");
//		BeanFactory factory = new XmlBeanFactory(resource);
//		HelloService helloService = (HelloService) factory.getBean("hs");
		
		System.out.println("프로그램 시작!!!");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/kitri/hello3/applicationContext.xml");	//xml읽어오는 도중에 
//		System.out.println("설정파일 읽어옴!!!");
		
		HelloService helloService = context.getBean("hs", HelloService.class);
//		System.out.println("서비스 얻어옴!!!");
		
		String msg = helloService.hello("안효인");
		
		System.out.println(msg);
		
		
//		HelloService h1 = new HelloServiceKor();
//		HelloService h2 = new HelloServiceKor();
//		System.out.println(h1 + "    " + h2);	// 서로 다른 객체가 생성됨
//		
//		
//		HelloService h3 = context.getBean("hs", HelloService.class);	// 새로 객체 생성하지 않음, xml을 읽어오는 도중에 생성된 객체를 불러옴
//		HelloService h4 = context.getBean("hs", HelloService.class);
//		System.out.println(h3 + "    " + h4);
		
		
		
		
	}
	
}


//http://maven.springframework.org/release/org/springframework/spring/



