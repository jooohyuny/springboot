package com.yun.aug071j.coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CoffeeController {

	@Autowired
	private CoffeeDAO cDAO;
	
	@RequestMapping("/coffee.reg")
	public String coffeeReg(Coffee c, HttpServletRequest req) {
		cDAO.reg(c,req);
		cDAO.get(req);
		return "index";
	}
	@RequestMapping("/coffee.update")
	public String coffeeUpdate(Coffee c, HttpServletRequest req) {
		cDAO.update(c,req);
		cDAO.get(req);
		return "index";
	}
	@RequestMapping("/coffee.delete")
	public String coffeeDelete(Coffee c, HttpServletRequest req) {
		cDAO.delete(c,req);
		cDAO.get(req);
		return "index";
	}
}
