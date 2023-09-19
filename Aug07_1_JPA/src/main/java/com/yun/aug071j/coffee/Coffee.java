package com.yun.aug071j.coffee;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// HTML -> Servlet -> JSP 



@NoArgsConstructor
@AllArgsConstructor
@Data
// 테이블명과 자바빈 클래스명 같으면 알아서 인식
@Entity(name="aug07_coffee") // 테이블명/자바빈이름 달라서
public class Coffee {
	// DB필드명/멤버변수명 같으면 알아서 인식
	// setC_name, getC_name형태로 나올텐데 -> 인식못함
	// setName, getName형태면 인식 하는데
	@Id // primary key
	@Column(name="c_name")	// c_name필드랑 연결
	private String name;	// 이런 형태여야 JPA써먹을수있고
							// DB필드명이랑 달라서 자동연결은 안되고
	
	@Column(name="c_price") // c_price필드랑 연결
	private Integer price;
}
