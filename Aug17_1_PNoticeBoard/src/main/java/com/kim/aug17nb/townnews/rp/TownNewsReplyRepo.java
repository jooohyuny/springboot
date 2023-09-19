package com.kim.aug17nb.townnews.rp;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TownNewsReplyRepo extends CrudRepository<TownNewsReply, Integer>{
	public abstract List<TownNewsReply> findAll(); // 게시판 테이블 전체조회
}
