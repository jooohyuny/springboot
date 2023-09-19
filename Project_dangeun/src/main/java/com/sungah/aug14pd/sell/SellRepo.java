package com.sungah.aug14pd.sell;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sungah.aug14pd.up.Profile;



@Repository
public interface SellRepo extends CrudRepository<Sell, String>{
	public abstract List<Sell> findAll(Pageable p);
	
	public abstract Optional<Sell> findById(String id);
	
	public abstract List<Sell> findByCategory(String category, Pageable p);
	public abstract List<Sell> findByCategoryOrderByViewDesc(String category, Pageable p);
	
	public abstract Sell findById(Integer id);
	
	public abstract List<Sell> findByState(String state, Pageable p);
	
	public abstract List<Sell> findByMemberId(Profile memberId, Pageable p);
	
	public abstract List<Sell> findByMemberIdAndState(Profile id, String state, Pageable p);
//	public abstract List<Sell> findByMemberIdAndState(Profile memberId, Sell state);
	
	/////////////////////////////////////////////////////////
	public abstract List<Sell> findAllByOrderByUpdateDateDesc();
	public abstract List<Sell> findByNameContainingOrderByUpdateDateDesc(String search);
	public abstract List<Sell> findByCategoryOrderByUpdateDateDesc(String category);
}