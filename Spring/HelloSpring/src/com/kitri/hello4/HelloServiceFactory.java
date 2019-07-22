package com.kitri.hello4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration	//이 클래스를 설정파일로 사용하겠다는 의미
public class HelloServiceFactory {

	@Bean(name = {"hs", "helloservice"})
	@Scope(value = "prototype")
	public HelloService getHelloService() {
		return new HelloServiceKor();
	}
	
}
