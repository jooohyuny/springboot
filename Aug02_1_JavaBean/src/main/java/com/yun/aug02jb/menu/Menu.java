package com.yun.aug02jb.menu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Component	// 객체 하나 등록해놓기
public class Menu {
	@Value("제육덮밥") // 등록해놓은 그 객체 속성값
	private String name;
	@Value("5000")
	private int price;
}
