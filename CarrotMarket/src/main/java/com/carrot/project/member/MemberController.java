package com.carrot.project.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MemberController {
	
	
	@RequestMapping(value="/member.login", method = RequestMethod.POST)
	public String memberLogin(HttpServletRequest req) {
		return "login";
	}
	
	@RequestMapping("/member.login")
	public String memberlogined(HttpServletRequest req) {
		return "login";
	}
	
}
