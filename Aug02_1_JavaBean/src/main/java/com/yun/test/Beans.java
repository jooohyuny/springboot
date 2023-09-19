package com.yun.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yun.aug02jb.snack.Snack;

@Configuration
public class Beans {

	@Bean("ss1")
	public Snack getS1() {
		Snack s = new Snack("초코파이",5000);
		return s;
	}
	
	@Bean("ss2")
	public Snack getS2() {
		Snack s = new Snack();
		s.setName("오예스");
		s.setPrice(6000);
		return s;
	}
	
}
