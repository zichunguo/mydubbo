package com.dubbo.test;

import java.io.IOException;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDubbo
@EnableHystrix
public class Application {
	
	public static void main(String[] args) throws IOException {
		SpringApplication.run(Application.class, args);
	}

}
