package com.daldal.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@RequestMapping(value="/loginform")
	public String loginform() {
		
		return "user/loginform";
	}
	
	@RequestMapping(value="/joinform")
	public String joinform() {
		
		return "user/joinform";
	}
	
	@RequestMapping(value="/writeform")
	public String writeform() {
		
		return "write/writeform";
	}
	
	@RequestMapping(value="/overlap")
	public String overlapform() {
		
		return "user/overlap";
	}
}
