package com.dubbo.test;

import java.io.IOException;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class Application {
	
	public static void main(String[] args) throws IOException {
		SpringApplication.run(Application.class, args);
	}

}
