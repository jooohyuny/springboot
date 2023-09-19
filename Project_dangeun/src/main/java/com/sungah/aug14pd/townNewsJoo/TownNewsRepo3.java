package com.sungah.aug14pd.townNewsJoo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TownNewsRepo3 extends CrudRepository<TownNews3, Integer>{
	public abstract List<TownNews3> findBytownNewsMemberId(TownNews3 townNewsMemberId);
	public abstract void deleteBytownNewsNum(Integer i);
	@Query("SELECT t FROM townnews t WHERE t.townNewsNum = :townNewsNum")
    Optional<TownNews3> findByTownNewsNum(@Param("townNewsNum") Integer townNewsNum);
	public abstract List<TownNews3> findAll(Pageable pageable); // 게시판 테이블 전체조회
}
