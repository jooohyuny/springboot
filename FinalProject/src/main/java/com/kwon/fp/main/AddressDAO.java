package com.kwon.fp.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kwon.fp.member.Member;
import com.kwon.fp.member.MemberRepo;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class AddressDAO {
	
	@Autowired
	private MemberRepo mr;

	@Transactional
	public void updateLoc(HttpServletRequest req, String districtName) {
//		AddressData ad=new AddressData();
		Member m = (Member) req.getSession().getAttribute("loginMember");
//		ad.setId(m.getId());
//		ad.setAddr(districtName);
//		ar.save(ad);
		
		// 멤버의 위치 데이터를 업데이트
		Member memberForUpdate=new Member();
		memberForUpdate.setId(m.getId());
		memberForUpdate.setName(m.getName());
		memberForUpdate.setPw(m.getPw());
		memberForUpdate.setBirth(m.getBirth().substring(0,10));
		memberForUpdate.setLoc(m.getLoc());
		memberForUpdate.setPhoto(m.getPhoto());
		memberForUpdate.setAdmin(m.getAdmin());
		memberForUpdate.setAddr(m.getAddr());
		
		memberForUpdate.setLoc(districtName); // 변경된 부분: 멤버의 loc 필드에 주소 저장
	    
	    mr.save(memberForUpdate);
	    m.setLoc(districtName);
	    
	    req.getSession().setAttribute("loginMember", m);


	}
}
