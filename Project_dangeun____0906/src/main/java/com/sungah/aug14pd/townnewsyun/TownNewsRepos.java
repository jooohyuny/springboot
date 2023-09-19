package com.sungah.aug14pd.townnewsyun;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sungah.aug14pd.member.Member;
import com.sungah.aug14pd.up.Profile;


public interface TownNewsRepos extends CrudRepository<TownNewses, Integer> {
	@Query("SELECT t FROM townnews t WHERE t.townNewsNum = :townNewsNum")
    Optional<TownNewses> findByTownNewsNum(@Param("townNewsNum") Integer townNewsNum);
	public abstract List<TownNewses> findAll(Pageable pageable); // 게시판 테이블 전체조회	
	public abstract List<TownNewses> findByTownNewsMemberId(Profile townNewsMemberId);
	
}
