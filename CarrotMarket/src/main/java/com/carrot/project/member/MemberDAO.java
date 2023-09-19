package com.carrot.project.member;


import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class MemberDAO {

	@Autowired
	private MemberRepo mr;
	
	@Value("${file.dir}")
	private String fileDir;
	
	public Members getMemberIDById(Member m) {
		try {
			return new Members(mr.findIdByIdEquals(m));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private String getFileName(MultipartFile mf) {
		String fileName = mf.getOriginalFilename();
		String type = fileName.substring(fileName.lastIndexOf("."));
		fileName = fileName.replace(type, "");
		String uuid = UUID.randomUUID().toString();
		return fileName + uuid + type;
	}
	
	
	public void join(MultipartFile mf, Member m, HttpServletRequest req) {
		try {
			if (mf != null) {
				String file = getFileName(mf);
				File f = new File(fileDir + "/" + file);
				mf.transferTo(f); // 실제업로드
				m.setPhoto(file);
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "가입 실패(파일)");
			return;
		}
		
		try {
			m.setId(req.getParameter("id"));
			m.setName(req.getParameter("name"));
			m.setPw(req.getParameter("pw"));
			m.setName(req.getParameter("name"));
			String addr1 = req.getParameter("address1");
			String addr2 = req.getParameter("address2");
			String addr3 = req.getParameter("address3");
			m.setAddr(addr2 + "!" + addr3 + "!" + addr1);
			m.setAdmin(0);
			String birth = req.getParameter("birth");
			m.setBirth(birth);
			
			mr.save(m);
			req.setAttribute("result", "가입성공");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "가입 실패");
		}

	}
	
	public void login(Member inputMember, HttpServletRequest req, HttpSession session) {
		try {
			Member dbMember = mr.findByIdEquals(inputMember.getId());

			if (dbMember != null) {
				if (inputMember.getPw().equals(dbMember.getPw())) {
					session.setAttribute("loginMember", dbMember);
					session.setMaxInactiveInterval(10*60); // 10분
				} else {
					req.setAttribute("result", "로그인 실패(pw오류)");
				}
			} else {
				req.setAttribute("result", "로그인 실패(없는 계정)");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "로그인 실패(DB)");
		}
	}
	
	public boolean isLogined(HttpServletRequest req, HttpSession session) {
		Member m = (Member) session.getAttribute("loginMember");
		if (m != null) {
			req.setAttribute("loginPage", "logined.html");
			return true;
		} else {
			req.setAttribute("loginPage", "unLogined.html");
			return false;
		}
	}

	public void logout(HttpServletRequest req, HttpSession session) {
		session.setAttribute("loginMember", null);
	}
}
