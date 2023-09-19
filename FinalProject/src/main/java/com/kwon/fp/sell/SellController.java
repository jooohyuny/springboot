package com.kwon.fp.sell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kwon.fp.main.ProductDAO;
import com.kwon.fp.member.memberDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
public class SellController {
	
	@Autowired
	private SellDAO sDAO;
	
	@Autowired
	private memberDAO mDAO;
	
	@Autowired
	private ProductDAO pDAO;
	
	@RequestMapping("/go.sell")
	public String goSell(HttpServletRequest req, HttpSession session) {
		mDAO.isLogined(req, session);
		return "sellUpload";
	}

	@RequestMapping("/sellUpload")
	public String upload(@RequestParam("photoo") MultipartFile mf,Sell s, HttpServletRequest req,String itemId, HttpSession session) {
		mDAO.isLogined(req, session);
		sDAO.upload(mf, s, req);
		pDAO.get(req);
		req.setAttribute("contentPage", "product.html");
		return "index";
	}
	
	@RequestMapping("/go.detail")
	public String getDetail(@RequestParam("id") String itemId,@RequestParam("category") String category,HttpServletRequest req, HttpSession session) {
		mDAO.isLogined(req, session);
	    sDAO.getDetail(req, itemId);
	    category = category.replace("\"", "");
	    sDAO.getByCategory(category, req);
	    return "productDetail";
	}
	
	@RequestMapping("/photo/{n}")
	public @ResponseBody Resource getPhoto(@PathVariable("n") String name) {
		return sDAO.getPhoto(name);
	}
	
	@RequestMapping("/go.delete")
	public String delete(Sell s, HttpServletRequest req, HttpSession session) {
		mDAO.isLogined(req, session);
		sDAO.delete(s, req);
		req.setAttribute("contentPage", "product.html");
		return "index";
	}
	
	@RequestMapping("/go.update")
	public String goUpdate(@RequestParam("id") String itemId, HttpServletRequest req,HttpSession session) {
		mDAO.isLogined(req, session);
		sDAO.goUpdate(req, itemId);
		sDAO.getPhoto(itemId);
		return "updateProduct";
	}
	
	@RequestMapping("/do.update")
	public String doUpdate(@RequestParam("photoo") MultipartFile mf, Sell s, HttpServletRequest req,@RequestParam("id") String itemId, @RequestParam("category") String category,HttpSession session) {
		mDAO.isLogined(req, session);
		sDAO.update(mf, s, req, itemId);
		sDAO.getDetail(req,itemId);
		category = category.replace("\"", "");
		sDAO.getByCategory(category, req);
		return "productDetail";
	}
	
}
