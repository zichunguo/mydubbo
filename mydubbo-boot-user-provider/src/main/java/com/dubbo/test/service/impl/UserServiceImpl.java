package com.dubbo.test.service.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import com.dubbo.test.bean.UserAddress;
import com.dubbo.test.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 1、将服务提供者注册到注册中心（暴露服务）
 * 		1）导入dubbo依赖、操作zookeeper的客户端（curator）
 * 		2）配置服务提供者
 * 		
 * 2、服务消费者去注册中心订阅服务提供者的服务地址
 * @author chun
 *
 */
@Service
@Component
public class UserServiceImpl implements UserService {

	@Override
//	@HystrixCommand
//	@HystrixCommand(fallbackMethod = "getUserAddressList_fall")
	public List<UserAddress> getUserAddressList(String userId) {
		System.out.println("******  000  ******");
		UserAddress address1 = new UserAddress(1, "北京", "1", "张三", "18812345678", "Y");
		UserAddress address2 = new UserAddress(2, "添加", "2", "李四", "17722223333", "N");
		if (Math.random() > 0.5) {
			throw new RuntimeException();
		}
		return Arrays.asList(address1, address2);
	}
	
	public List<UserAddress> getUserAddressList_fall(String userId) {
		System.out.println("*********** getUserAddressList_fall **************");
		return Arrays.asList(new UserAddress(0, "无", "0", "无", "***", "Y"));
	}

}
