package com.yun.project.townnews;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yun.project.member.Member;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class TownNewsDAO {

	@Autowired
	private TownNewsRepo tr;

	@Autowired
	private TownNewsReplyRepo trr;
	
	
	public void getMyTownNews(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		try {
//			List<TownNews> townNews = tr.findByTownNewsMemberId(member.getId().equals(m));
			List<TownNews> townNews = tr.findByTownNewsMemberId(m);
			List<TownNewsReply> townNewsReply = trr.findAll();
			
			req.setAttribute("townNewsReply", townNewsReply);
			req.setAttribute("tn", townNews);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
