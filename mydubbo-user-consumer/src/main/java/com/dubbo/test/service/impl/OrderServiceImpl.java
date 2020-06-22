package com.dubbo.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dubbo.test.bean.UserAddress;
import com.dubbo.test.service.OrderService;
import com.dubbo.test.service.UserService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private UserService userService;
	@Override
	public void initOrder(String userId) {
		System.out.println("userId :" + userId);
		// 1.查询用户收货地址
		List<UserAddress> userAddressList = userService.getUserAddressList(userId);
		for (UserAddress userAddress : userAddressList) {
			System.out.println(userAddress);
		}
	}

}
