package com.dubbo.test;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ImportResource;

/**
 * 导入依赖：dubbo-starter 及 dubbo 的其他依赖
 * 
 * SpringBoot 和 dubbo 整合的三种方式：
 * 		1）导入 dubbo-starter，在 application.properties 配置属性，使用@Service【暴露服务】，使用@Reference【引用服务】
 * 		2）保留 dubbo xml 配置文件
 * 			导入 dubbo-starter，使用@ImportResource导出dubbo的配置文件
 * 		3）使用注解API方式
 *			将每一个组件手动创建到容器中，让dubbo来扫描其他组件
 */
@SpringBootApplication
//@EnableDubbo // 开启基于注解的dubbo功能，方式一
//@ImportResource(locations = "classpath:provider.xml")	// 方式二
@EnableDubbo(scanBasePackages = "com.dubbo.test") // 方式三
//@EnableHystrix	// 开启服务容错
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
