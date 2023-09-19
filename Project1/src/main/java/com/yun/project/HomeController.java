package com.yun.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yun.project.member.MemberDAO;
import com.yun.project.product.ProductDAO;
import com.yun.project.product.WishProductDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private ProductDAO pDAO;

	@Autowired
	private MemberDAO mDAO;

	@Autowired
	private WishProductDAO wDAO;

	@RequestMapping("/")
	public String home(HttpServletRequest req, HttpSession session) {
		mDAO.isLogined(req, session);
		pDAO.get(req);
		req.setAttribute("contentPage", "product.html");
		return mDAO.showIndex(req, session);
	}


}
