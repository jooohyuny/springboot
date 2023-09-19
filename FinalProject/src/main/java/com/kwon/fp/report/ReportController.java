package com.kwon.fp.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kwon.fp.member.memberDAO;
import com.kwon.fp.up.ProfileDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import oracle.jdbc.internal.PDBChangeEvent;

@Controller
public class ReportController {


	@Autowired
	private ReportDAO rDAO;
	
	@Autowired
	private memberDAO mDAO;
	
	@Autowired
	private ProfileDAO pDAO;
	
	@RequestMapping("/go.report")
	public String goReport(HttpServletRequest req, HttpSession session, String id) {
		if (mDAO.isLogined(req, session)) {
			pDAO.get(req, id);
			req.setAttribute("contentPage", "report.html");
			return "index";
		}
		req.setAttribute("contentPage", "product.html");
		return "index";
	}
	
	@RequestMapping("/do.report")
	public String doReport(@RequestParam("photoo") MultipartFile mf, Report r,HttpServletRequest req, HttpSession session) {
		if (mDAO.isLogined(req, session)) {
			rDAO.report(mf, r, req);
			req.setAttribute("contentPage", "product.html");
			return "index";
		}
		req.setAttribute("contentPage", "product.html");
		return "index";
	}
}
