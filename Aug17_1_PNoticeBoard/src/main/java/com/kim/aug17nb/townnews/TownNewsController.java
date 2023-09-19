package com.kim.aug17nb.townnews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kim.aug17nb.townnews.rp.TownNewsReply;
import com.kim.aug17nb.townnews.rp.TownNewsReplyDAO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TownNewsController {

	@Autowired
	private TownNewsDAO tnDAO;

	@Autowired
	private TownNewsFileDAO tnfDAO;

	@Autowired
	private TownNewsReplyDAO tnrDAO;

	// 게시판 조회
	@GetMapping("/townnews.go")
	public String townNewsPage(@RequestParam(name = "page", defaultValue = "1") int page,
		TownNews tn, HttpServletRequest req) {
		tnDAO.getTownsNewsPage(page, req); // 조회 및 페이지 나누기
		return "townNews";
	}

	// 게시판 이미지 띄우기
	@GetMapping("/photo/{n}")
	@ResponseBody
	public Resource getTownNewsFile(@PathVariable("n") String name) {
		return tnfDAO.getTownNewsPhoto(name);
	}

	// 게시판 등록
	@PostMapping("/townnews/write")
	public String townNewsWrite(@RequestParam("townNewsPhotoo") MultipartFile mf, TownNews tn, HttpServletRequest req) {
		tnfDAO.uploadTownNewsFile(mf, tn, req); // 이미지 등록
		tnDAO.regTownNews(tn, req); // 게시글 등록
		return "redirect:/townnews.go";
	}

	// 게시판 수정
	@GetMapping("/townnews/edit")
	public String townNewsEdit(TownNews tn, HttpServletRequest req) {
		tnDAO.getTownNewsContents(req);
		return "townnews/write";
	}

	// 게시판 삭제
	@PostMapping("/townnews/delete")
	public String townNewsDelete(TownNews tn, HttpServletRequest req) {
		tnDAO.townNewsDelete(tn, req);
		return "redirect:/townnews.go";
	}

	// 댓글 작성
	@PostMapping("/townnews/reply")
	public String townNewsReplyPage(TownNewsReply tnr, HttpServletRequest req) {
		tnrDAO.regTownNewsReply(tnr, req);
		return "redirect:/townnews.go";
	}

}
