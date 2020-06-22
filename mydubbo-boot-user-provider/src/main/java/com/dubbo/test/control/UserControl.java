package com.dubbo.test.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControl {

	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "test";
	}
	
}
