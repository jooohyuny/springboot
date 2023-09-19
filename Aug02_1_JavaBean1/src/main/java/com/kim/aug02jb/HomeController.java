package com.kim.aug02jb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kim.aug02jb.snack.Snack;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		Snack s = new Snack("초코파이", 3000);
		
		return "index";
	}
}
