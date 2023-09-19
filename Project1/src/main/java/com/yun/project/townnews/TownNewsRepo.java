package com.yun.project.townnews;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.yun.project.member.Member;

public interface TownNewsRepo extends CrudRepository<TownNews, Integer> {
	@Query("SELECT t FROM townnews t WHERE t.townNewsNum = :townNewsNum")
    Optional<TownNews> findByTownNewsNum(@Param("townNewsNum") Integer townNewsNum);

	public abstract List<TownNews> findAll(Pageable pageable); // 게시판 테이블 전체조회	
	
	
	public abstract List<TownNews> findByTownNewsMemberId(Member townNewsMemberId);

}
