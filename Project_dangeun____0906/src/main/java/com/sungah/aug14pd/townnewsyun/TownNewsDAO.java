package com.sungah.aug14pd.townnewsyun;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sungah.aug14pd.member.Member;
import com.sungah.aug14pd.up.Profile;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class TownNewsDAO {

	@Autowired
	private TownNewsRepos tr;

	@Autowired
	private TownNewsReplyRepos trr;
	
	
	public void getMyTownNews(HttpServletRequest req, Profile mId) {
//		Profile m = (Profile) req.getSession().getAttribute("loginMember");
		try {
//			List<TownNews> townNews = tr.findByTownNewsMemberId(member.getId().equals(m));
			List<TownNewses> townNews = tr.findByTownNewsMemberId(mId);
			List<TownNewsReplys> townNewsReply = trr.findAll();
			
			req.setAttribute("townNewsReply", townNewsReply);
			req.setAttribute("tn", townNews);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
