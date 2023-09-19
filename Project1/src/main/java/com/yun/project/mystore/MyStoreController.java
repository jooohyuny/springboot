package com.yun.project.mystore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yun.project.member.Member;
import com.yun.project.member.MemberDAO;
import com.yun.project.member.MemberRepo;
import com.yun.project.product.ProductDAO;
import com.yun.project.product.ProductRepo;
import com.yun.project.product.PurchaseHistory;
import com.yun.project.product.PurchaseHistoryRepo;
import com.yun.project.product.WishProductDAO;
import com.yun.project.report.Report;
import com.yun.project.report.ReportDAO;
import com.yun.project.townnews.TownNewsDAO;
import com.yun.project.townnews.TownNewsRepo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyStoreController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private ProductDAO pDAO;
	
	@Autowired
	private WishProductDAO wDAO;

	@Autowired
	private ReportDAO rDAO;

	@Autowired
	private TownNewsDAO tDAO;
	
	@Autowired
	private MemberRepo mr;
	
	@Autowired
	private ProductRepo pr;
	
	@Autowired
	private PurchaseHistoryRepo phr;

	@Autowired
	private TownNewsRepo tr;
	
	
	@RequestMapping("/photoyun/{n}")
	public @ResponseBody Resource getPhoto(@PathVariable("n") String name) {
		return pDAO.getPhoto(name);
	}
	
	
    @RequestMapping("/mystore.sale")
    public String getMySaleProducts(HttpServletRequest req, HttpSession session, @RequestParam("id")Member id) {
    	if (mDAO.isLogined(req, session)) {
    		pDAO.getSales(req);
    		req.setAttribute("contentPage", "store.html");
    		return "mystore"; // 적절한 뷰 이름으로 변경
		}
        return "redirect:/member.login.go"; // 로그인되지 않았을 경우 처리
    }

    @RequestMapping("/mystore.sold")
    public String getMySoldProducts(HttpServletRequest req, HttpSession session, @RequestParam("id")Member id) {
    	if (mDAO.isLogined(req, session)) {
    		pDAO.getSoldOut(req);
    		req.setAttribute("contentPage", "soldoutStore.html");
    		return "mystore"; // 적절한 뷰 이름으로 변경
    	}
    	return "redirect:/member.login.go"; // 로그인되지 않았을 경우 처리
    }

    @RequestMapping("/mystore.purchase")
    public String getMyPurchaseProducts(HttpServletRequest req, HttpSession session, @RequestParam("id")Member id) {
    	if (mDAO.isLogined(req, session)) {
    		pDAO.getPurchaseHistory(req);
    		req.setAttribute("contentPage", "purchase.html");
    		return "mystore"; // 적절한 뷰 이름으로 변경
    	}
    	return "redirect:/member.login.go"; // 로그인되지 않았을 경우 처리
    }

	
	@RequestMapping("/mystore.wishlist.go")
	public String getWishlist(@RequestParam("id") Member memberId, HttpServletRequest req,HttpSession session) {
		if(mDAO.isLogined(req, session)) {
			wDAO.getWishlist(req, memberId);
			req.setAttribute("contentPage", "wishlist.html");
			return "mystore";
		}
		return "redirect:/member.login.go"; // 로그인되지 않았을 경우 처리
	}
	
//	@RequestMapping("/mystore.wishList.remove")
//	public String removeWishlist(@RequestParam String memberId, @RequestParam Integer productId, HttpServletRequest req,HttpSession session) {
//		if(mDAO.isLogined(req, session)) {
//			if (wDAO.isProductWishlistdByUser(req, productId)) {
//				wDAO.removeWishlist(req, productId);
//			}
//			req.setAttribute("contentPage", "product.html");
//		}
//		return "wishList";
//	}
	
	
	@RequestMapping("/mystore.update.go")
	public String goProductStateUpdate(HttpServletRequest req, HttpSession session, @RequestParam("productId") Integer pId) {
		if(mDAO.isLogined(req, session)) {
			pDAO.confirm(req, pId);
			req.setAttribute("contentPage", "confirm.html");
			return "mystore";
		}
		return "redirect:/member.login.go"; // 로그인되지 않았을 경우 처리
	}

	@RequestMapping("/mystore.update.complete")
	public String productStateUpdateComplete(HttpServletRequest req, HttpSession session,
			@RequestParam("buyer") String buyerId,
			@RequestParam("productId") Integer productId 
			) {
		if(mDAO.isLogined(req, session)) {
			pDAO.soldOut(req, buyerId, productId);
			pDAO.getSoldOut(req);
			pDAO.getSales(req);
			req.setAttribute("contentPage", "soldoutStore.html");
			return "mystore";
		}
		return "redirect:/member.login.go"; // 로그인되지 않았을 경우 처리
	}
	
	
    @RequestMapping("/mystore.report.go")
    public String goMyreport(HttpServletRequest req, HttpSession session) {
    	if (mDAO.isLogined(req, session)) {
    		rDAO.getReport(req);
    		req.setAttribute("contentPage", "myReport.html");
    		return "mystore"; // 적절한 뷰 이름으로 변경
    	}
    	return "redirect:/member.login.go"; // 로그인되지 않았을 경우 처리
    }
    
    @RequestMapping("/mystore.report.detail")
    public String detailMyreport(HttpServletRequest req, HttpSession session, @RequestParam("rId") Integer rId) {
    	if (mDAO.isLogined(req, session)) {
    		rDAO.getReportDetail(req, rId);
    		req.setAttribute("contentPage", "reportDetail.html");
    		return "mystore"; // 적절한 뷰 이름으로 변경
    	}
    	return "redirect:/member.login.go"; // 로그인되지 않았을 경우 처리
    }
    
    @RequestMapping("/mystore.townnews.go")
    public String goMyTownNews(HttpServletRequest req, HttpSession session) {
    	if (mDAO.isLogined(req, session)) {
    		tDAO.getMyTownNews(req);
    		req.setAttribute("contentPage", "myTownNews.html");
    		return "mystore"; // 적절한 뷰 이름으로 변경
    	}
    	return "redirect:/member.login.go"; // 로그인되지 않았을 경우 처리
    }
    
    
    
}
