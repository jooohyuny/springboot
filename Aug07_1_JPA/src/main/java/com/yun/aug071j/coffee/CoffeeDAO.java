package com.yun.aug071j.coffee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class CoffeeDAO {
	
	@Autowired
	private CoffeeRepo cr;
	
	public void reg(Coffee c, HttpServletRequest req) {
		try {
			cr.save(c); // 알아서 insert문 만들어서...
			req.setAttribute("result", "등록성공");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "등록실패");
		}
	}
	
	public void get(HttpServletRequest req) {
		// select * from 테이블명
		try {
			// List<Coffee> coffees = cr.findAll(); // 알아서 select문 만들어서...
			// List<Coffee> coffees = cr.findByPriceGreaterThanEqual(5500);
			// List<Coffee> coffees = cr.findByNameContaining("라떼");
			Sort s = Sort.by(
					Sort.Order.desc("price"),
					Sort.Order.asc("name")
			);
			// 페이지번호(0번부터), 한페이지당 몇개, 정렬
			Pageable p = PageRequest.of(0, 5, s);
			List<Coffee> coffees = cr.findByNameContaining("",p);
			req.setAttribute("coffees", coffees);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Coffee c, HttpServletRequest req) {
		try {
			// 그 이름에 해당하는 커피 전체 정보 조회해오기
			c = cr.findById(c.getName()).get();
			
			// 그대로 둘 정보는 그대로 두고, 바꿀거는 바꾸고
			c.setPrice(0);
			
			// 똑같은 PK가 없으면 insert
			// 똑같은 PK가 있으면 update
			cr.save(c);
			
			req.setAttribute("result", "수정성공");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "수정실패");
		}
	}
	public void delete(Coffee c, HttpServletRequest req) {
		try {
			cr.deleteById(c.getName());
			req.setAttribute("result", "삭제성공");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "삭제실패");
		}
	}
	
}
