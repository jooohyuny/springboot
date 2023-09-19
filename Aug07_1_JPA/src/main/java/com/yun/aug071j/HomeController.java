package com.yun.aug071j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yun.aug071j.coffee.CoffeeDAO;

import jakarta.servlet.http.HttpServletRequest;

// JDBC -> ConnectionPool ->
// MyBatis :
// 		SQL을 .xml에 -> 유지보수 용아
//		ORM -> 자동으로 자바 객체
// JPA(Java Persistance API) : 아이디어 이름
//		SQL이 거기서 거기 -> 자동으로 만들어줌
//		ORM
// Hibernate : 실제 기술명 
//		JPA라는 아이디어를 구현해놓은 기술
// Spring Data JPA : Spring + Hibernate

// 글쓰기 : insert into safsagw_sns values
// 상품등록 : insert into ljoiwdn_prod
// 회원가입 : insert into

@Controller
public class HomeController {

	@Autowired
	private CoffeeDAO cDAO;
	
	@RequestMapping("/")
	public String home(HttpServletRequest req) {
		cDAO.get(req);
		return "index";
	}

}
