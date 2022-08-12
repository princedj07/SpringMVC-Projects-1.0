package org.spring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestAppController {

	@ResponseBody
	@RequestMapping("/test")
	public String sayHello() {
		return "Hey its working fine....";
	}
	
	@RequestMapping("/hello")
	public String helloWorld() {
		System.out.println("TestAppController.helloWorld()");
		return "hello-world";
	}
}
