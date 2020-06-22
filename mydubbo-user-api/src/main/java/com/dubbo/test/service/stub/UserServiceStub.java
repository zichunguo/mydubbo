package com.dubbo.test.service.stub;

import java.util.List;

import com.dubbo.test.bean.UserAddress;
import com.dubbo.test.service.UserService;

public class UserServiceStub implements UserService {
	
	private final UserService userService;
	
	/**
	 * 传入的是 UserService 远程的代理对象
	 * @param userService
	 */
	public UserServiceStub(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public List<UserAddress> getUserAddressList(String userId) {
		System.out.println("------ stub ------");
		if (!(userId == null || "".equals(userId))) {
			return this.userService.getUserAddressList(userId);
		}
		return null;
	}

}
