package com.dubbo.test.service;

import java.util.List;

import com.dubbo.test.bean.UserAddress;

public interface OrderService {
	
	/**
	 * 初始化订单
	 * @param userId
	 */
	public List<UserAddress> initOrder(String userId);

}
