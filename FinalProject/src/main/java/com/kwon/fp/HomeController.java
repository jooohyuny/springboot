package com.kwon.fp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kwon.fp.main.AddressDAO;
import com.kwon.fp.main.ProductDAO;
import com.kwon.fp.member.memberDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	memberDAO mDAO;
	
	@Autowired
	private ProductDAO pDAO;
	
	@Autowired
	private AddressDAO aDAO;
	
	@RequestMapping("/")
	public String home(HttpServletRequest req, HttpSession session) {
		mDAO.isLogined(req, session);
		pDAO.getCategory(req);
		pDAO.get(req);
		req.setAttribute("contentPage", "product.html");
		return mDAO.showIndex(req, session);
	}
	
	@RequestMapping(value = "/product.search")
	public String snsSearch(HttpServletRequest req) {
		pDAO.search(req);
		pDAO.getCategory(req);
		pDAO.get(req);
		req.setAttribute("contentPage", "product.html");
		return "index";
	}

	@RequestMapping(value = "/location.update.go")
	public String locationUpdateGo(HttpServletRequest req,HttpSession session) {
		mDAO.isLogined(req, session);
		pDAO.getCategory(req);
		req.setAttribute("contentPage", "location.html");
		return "index";
	}
	
	@RequestMapping(value ="/update.location")
	public String	 saveDistrict(@RequestParam String districtName, HttpServletRequest req) {
		aDAO.updateLoc(req,districtName);
		return "";
	}
	
	@RequestMapping("/photocho/{n}")
	public @ResponseBody Resource getPhoto(@PathVariable("n") String name) {
		return pDAO.getPhoto(name);
	}

	@RequestMapping(value = "/category/{categoryId}")
	public String getByCategory(HttpServletRequest req, @PathVariable("categoryId") String cgy) {
		pDAO.getCategory(req);
		pDAO.getByCategory(req, cgy);
		req.setAttribute("contentPage", "product.html");
		return "index";
	}

}
