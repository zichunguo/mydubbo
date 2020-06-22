package com.dubbo.test.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dubbo.test.bean.UserAddress;
import com.dubbo.test.service.OrderService;

@RestController
public class OrderControl {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/init/{id}")
	public List<UserAddress> initOrder(@PathVariable("id") String userId) {
		return orderService.initOrder(userId);
	}

}
