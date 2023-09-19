package com.yun.aug071j.coffee;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository										// 자바빈, Id준거 자료형
public interface CoffeeRepo extends CrudRepository<Coffee, String> {
	// 원래 Iterable<Coffee>로 나가니 V쪽에서 불편할 것
	// List<Coffee>로 나가게 리턴타입만 바꿔주는것
	public abstract List<Coffee> findAll();
	
	// 메소드명만 규칙에 맞춰서 지으면 
	public abstract List<Coffee> findByPriceGreaterThanEqual(Integer p);
	public abstract List<Coffee> findByNameContaining(String s);
	public abstract List<Coffee> findByNameContaining(String s, Pageable p);
}
