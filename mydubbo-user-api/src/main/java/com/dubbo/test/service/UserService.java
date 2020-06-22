package com.dubbo.test.service;

import java.util.List;

import com.dubbo.test.bean.UserAddress;

/**
 * 用户服务
 * @author chun
 *
 */
public interface UserService {
	
	/**
	 * 按照用户id返回所有的收货地址
	 * @param userId
	 * @return
	 */
	public List<UserAddress> getUserAddressList(String userId);

}
