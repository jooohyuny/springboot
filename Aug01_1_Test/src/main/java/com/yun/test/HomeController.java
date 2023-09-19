package com.yun.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	// /로 GET이든 POST든 요청들어오면
	@RequestMapping("/")
	public String home() {
		return "index"; // index.html로 포워딩
	}
	
	
}
