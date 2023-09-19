package com.yun.aug14pt.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login(HttpServletRequest req, HttpServletResponse res) {
		return "login";
	}
	
}
