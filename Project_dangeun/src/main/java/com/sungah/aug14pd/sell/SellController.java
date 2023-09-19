package com.sungah.aug14pd.sell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sungah.aug14pd.main.ProductDAO;
import com.sungah.aug14pd.member.MemberDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
public class SellController {
	
	@Autowired
	private SellDAO sDAO;
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private ProductDAO pDAO;
	
	
	@RequestMapping("/go.sell")
	public String goSell(HttpServletRequest req, HttpSession session) {
		if (mDAO.isLogined(req, session)) {
			req.setAttribute("contentPage", "sellUpload.html");
			return "index";
		}
		req.setAttribute("contentPage", "product.html");
		return "index";
	}

	@RequestMapping("/sellUpload")
	public String upload(@RequestParam("photoo") MultipartFile mf,Sell s, HttpServletRequest req,String itemId, HttpSession session, String search) {
		if (mDAO.isLogined(req, session)) {
			sDAO.upload(mf, s, req);
			pDAO.get(req, search);
			req.setAttribute("contentPage", "product.html");
			return "index";
		}
		req.setAttribute("contentPage", "product.html");
		return "index";
	}
	
	@RequestMapping("/go.detail")
	public String getDetail(@RequestParam("id") String itemId,@RequestParam("category") String category,HttpServletRequest req, HttpSession session) {
		if (mDAO.isLogined(req, session)) {
			sDAO.getDetail(req, itemId);
			category = category.replace("\"", "");
			sDAO.getByCategory(category, req);
			req.setAttribute("contentPage", "productDetail.html");
			return "index";
		}
		req.setAttribute("contentPage", "product.html");
		return "index";
		
	}
	
	@RequestMapping("/photokwon/{n}")
	public @ResponseBody Resource getPhoto(@PathVariable("n") String name) {
		return sDAO.getPhoto(name);
	}
	
	@RequestMapping("/go.delete")
	public String delete(Sell s, HttpServletRequest req, HttpSession session) {
		if (mDAO.isLogined(req, session)) {
			sDAO.delete(s, req);
			req.setAttribute("contentPage", "product.html");
			return "index";
		}
		req.setAttribute("contentPage", "product.html");
		return "index";
	}
	
	@RequestMapping("/do.dateupdate")
	public String dateUpdate(Sell s, HttpServletRequest req, HttpSession session,@RequestParam("id") String itemId) {
		if (mDAO.isLogined(req, session)) {
			sDAO.updateDate(s, req, itemId);
			req.setAttribute("contentPage", "product.html");
			return "index";
		}
		req.setAttribute("contentPage", "product.html");
		return "index";
	}
	
	@RequestMapping("/go.update")
	public String goUpdate(@RequestParam("id") String itemId, HttpServletRequest req,HttpSession session) {
		if (mDAO.isLogined(req, session)) {
			sDAO.goUpdate(req, itemId);
			sDAO.getPhoto(itemId);
			req.setAttribute("contentPage", "updateProduct.html");
			return "index";
		}
		req.setAttribute("contentPage", "product.html");
		return "index";
	}
	
	@RequestMapping("/do.update")
	public String doUpdate(@RequestParam("photoo") MultipartFile mf, Sell s, HttpServletRequest req,@RequestParam("id") String itemId, @RequestParam("category") String category,HttpSession session) {
		if (mDAO.isLogined(req, session)) {
			sDAO.update(mf, s, req, itemId);
			sDAO.getDetail(req,itemId);
			category = category.replace("\"", "");
			sDAO.getByCategory(category, req);
			req.setAttribute("contentPage", "product.html");
			return "index";
		}
		req.setAttribute("contentPage", "product.html");
		return "index";
	}
	
}
