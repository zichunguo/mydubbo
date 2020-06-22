package com.dubbo.test.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dubbo.test.bean.UserAddress;
import com.dubbo.test.service.OrderService;
import com.dubbo.test.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class OrderServiceImpl implements OrderService {

//	@Autowired
//	@Reference(url = "127.0.0.1:20880", version = "1.0.0")	// dubbo直连
	@Reference(loadbalance = "roundrobin", version = "1.0.0")
	private UserService userService;
	
	@Override
	@HystrixCommand(fallbackMethod = "initOrder_fall")
	public List<UserAddress> initOrder(String userId) {
		System.out.println("userId :" + userId);
		// 1.查询用户收货地址
		List<UserAddress> userAddressList = userService.getUserAddressList(userId);
		for (UserAddress userAddress : userAddressList) {
			System.out.println(userAddress);
		}
		return userAddressList;
	}
	
	public List<UserAddress> initOrder_fall(String userId) {
		System.out.println("*********** initOrder_fall **************");
		return Arrays.asList(new UserAddress(0, "无", "0", "无", "***", "Y"));
	}

}
