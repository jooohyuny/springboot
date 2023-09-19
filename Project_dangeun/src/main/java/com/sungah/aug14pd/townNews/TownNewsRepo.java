package com.sungah.aug14pd.townNews;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sungah.aug14pd.townNewsJoo.TownNews3;

@Repository
public interface TownNewsRepo extends CrudRepository<TownNews, Integer> {
	//public abstract List<TownNews> findAll(Pageable currentPageable); // 게시판 테이블 전체조회
	public abstract List<TownNews> findBytownNewsMemberId(String s);
	public abstract void deleteBytownNewsNum(Integer i);
	

}
