package com.dubbo.test.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.MethodConfig;
import org.apache.dubbo.config.MonitorConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dubbo.test.service.UserService;

@Configuration
public class MyDubboConfig {
	
	@Bean
	public ApplicationConfig applicationConfig() {
		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setName("user-provider-boot");
		return applicationConfig;
	}
	
	@Bean
	public RegistryConfig registryConfig() {
		RegistryConfig registryConfig = new RegistryConfig();
		registryConfig.setProtocol("zookeeper");
		registryConfig.setAddress("localhost:2181");
		return registryConfig;
	}
	
	@Bean
	public ProtocolConfig protocolConfig() {
		ProtocolConfig protocolConfig = new ProtocolConfig();
		protocolConfig.setName("dubbo");
		protocolConfig.setPort(20880);
		return protocolConfig;
	}
	
	@Bean
	public ServiceConfig<UserService> userServiceConfig(UserService userService) {
		ServiceConfig<UserService> userServiceConfig = new ServiceConfig<UserService>();
		userServiceConfig.setInterface(UserService.class);
		userServiceConfig.setRef(userService);
		userServiceConfig.setVersion("1.0.0");
		
		// 配置每一个method信息
		MethodConfig methodConfig = new MethodConfig();
		methodConfig.setName("getUserAddressList");
		methodConfig.setTimeout(3000);
		
		List<MethodConfig> methods = new ArrayList<MethodConfig>();
		methods.add(methodConfig);
		
		// 将method设置关联到service配置中
		userServiceConfig.setMethods(methods);
		return userServiceConfig;
	}
	
	@Bean
	public MonitorConfig monitorConfig() {
		MonitorConfig monitorConfig = new MonitorConfig();
		monitorConfig.setProtocol("registry");
		return monitorConfig;
	}

}
