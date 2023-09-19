package com.kim.aug02jb.snack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 				// getter/setter
@AllArgsConstructor // 오버로딩된 생성자
@NoArgsConstructor // 기본생성자
public class Snack {
	private String name;
	private int price;
}

