package com.sungah.aug14pd.townNewsJoo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TownNewsReplyRepo2 extends CrudRepository<TownNewsReply2, Integer>{
	public abstract List<TownNewsReply2> findAll(); // 게시판 테이블 전체조회
}
