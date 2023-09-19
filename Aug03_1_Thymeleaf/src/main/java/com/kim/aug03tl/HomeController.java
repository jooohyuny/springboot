package com.kim.aug03tl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Servlet : HTML/CSS/JS를 만드는 자바 프로그램
// -----작업이 불편해서
// Jsp : 웹바탕에 자바소스 넣는 형태
//		.jsp에 자바소스 넣어지니까 좋다
// -----분업
// JSP Model 2 : JSP에 MVC패턴
//				.jsp에 자바소스가 들어가면 안될텐데..
// -----V쪽에 자바소스가
// JSP Model 2 + EL + JSTL
//		자바소스가 하던거를 EL/JSTL이 담당
//		=> 그래서 .jsp가 하는일이 뭔데..
//		=> .jsp는 서블릿으로 바꿔서 실행해야하니
//				느려
//				톰캣이 없으면 아예 실행 불가
// => Spring Boot에서는 .jsp 비추

//		HTML템플릿엔진을 권장(Thymeleaf)

// => 결론 : .jsp + EL + JSTL -> Thymeleaf

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "input";
	}
}
