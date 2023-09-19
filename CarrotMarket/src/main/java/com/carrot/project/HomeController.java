package com.carrot.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carrot.project.member.Member;
import com.carrot.project.member.MemberDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping("/")
	public String home(HttpServletRequest req, HttpSession session) {
//		req.setAttribute("contentPage", "home");
		mDAO.isLogined(req, session);
		return "index";
	}
	
	@RequestMapping("/index.do")
	public String indexDo(Member m,HttpServletRequest req, HttpSession session) {
		mDAO.login(m, req, session);
		mDAO.isLogined(req, session);
		return "index";
	}
	
	
	
}
