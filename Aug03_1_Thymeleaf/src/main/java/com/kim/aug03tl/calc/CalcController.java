package com.kim.aug03tl.calc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CalcController {
	
	@Autowired
	private Calculator c;
	
	@RequestMapping("/xy.calculate")
	public String xyCalculate(CalcResult cr, HttpServletRequest req) {
		c.calculate(cr, req);
		req.setAttribute("contentPage", "abcd"); // 확장자 빼고 html파일명 : abcd
		req.setAttribute("contentPageSub", "aaa"); // th:fragment이름 : aaa
		return "output";
	}
}
