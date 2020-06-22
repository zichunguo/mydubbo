package com.dubbo.test;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:/provider.xml");
		ioc.start();
		
		System.in.read(); // 按任意键退出
	}

}
