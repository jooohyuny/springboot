package com.sungah.aug14pd.townNewsJoo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sungah.aug14pd.townNews.TownNewsRepo;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class TownNewsDAO {
	
	@Autowired
	private TownNewsRepo3 tnr;
	
	@Autowired
	private TownNewsReplyRepo2 tnrr;
	
	// 게시판 등록 메소드
	public void regTownNews(TownNews3 tn, HttpServletRequest req) {
		try {
			tnr.save(tn); // 게시글 등록
			req.setAttribute("result", "등록성공");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "등록실패");
		}
	}
	
	
	public void getTownsNewsPage(int page, HttpServletRequest req) {
	    try {
	        Sort s = Sort.by(
	                Sort.Order.desc("townNewsNum") // "townNewsNum" 필드를 기준으로 최신순으로 정렬
	        );

	        int pageSize = 3; // 페이지당 데이터 수

	        // 총 데이터 수 확인
	        long totalItems = tnr.count();

	        int totalPages = (int) Math.ceil((double) totalItems / pageSize); // 총 페이지 수

	        int startPage = Math.max(page - 4, 1); // 첫 번째 페이지 번호
	        int endPage = Math.min(page + 5, totalPages); // 마지막 페이지 번호

	        Pageable pageAble = PageRequest.of(page - 1, pageSize, s); // 참고: 페이지는 0부터 시작합니다.

	        List<TownNews3> townNews = tnr.findAll(pageAble);
	        List<TownNewsReply2> townNewsReply = tnrr.findAll();

	        req.setAttribute("townNewsReply", townNewsReply);
	        req.setAttribute("tn", townNews);
	        req.setAttribute("totalPages", totalPages); // 총 페이지 수 전달
	        req.setAttribute("currentPage", page); // 현재 페이지 번호 전달
	        req.setAttribute("startPage", startPage); // 시작 페이지 번호 전달
	        req.setAttribute("endPage", endPage); // 마지막 페이지 번호 전달
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


	
	
	// 게시판 내용 가져오기
	public void getTownNewsContents(HttpServletRequest req) {
	    try {
	        // HttpServletRequest에서 townNewsNum 변수를 가져옵니다.
	        Integer townNewsNum = Integer.parseInt(req.getParameter("townNewsNum"));

	        // findById 메서드를 사용하여 TownNews 엔티티를 찾습니다.
	        Optional<TownNews3> townNewsOptional = tnr.findById(townNewsNum);

	        if (townNewsOptional.isPresent()) {
	            TownNews3 townNews = townNewsOptional.get();
	            
	            req.setAttribute("townNewsTitle", townNews.getTownNewsTitle());
	            req.setAttribute("townNewsText", townNews.getTownNewsText());
	            req.setAttribute("townNewsPhotoo", townNews.getTownNewsPhoto());

	        } else {
	            // 해당 townNewsNum에 해당하는 데이터를 찾을 수 없을 때 처리
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	// 삭제메소드
	public void townNewsDelete(TownNews3 tn, HttpServletRequest req) {
		try {
			tnr.deleteById(tn.getTownNewsNum());
			req.setAttribute("result", "삭제성공");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "삭제실패");
		}
	}
	
}
