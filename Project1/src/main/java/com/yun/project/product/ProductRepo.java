package com.yun.project.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yun.project.member.Member;

@Repository
public interface ProductRepo extends CrudRepository<Products, Integer>{

	public abstract List<Products> findAll();
	public abstract List<Products> findByState(String state);
	public abstract List<Products> findAllByState(String state);
	public abstract List<Products> findByStateAndMemberId(String state, Member memberId);
	public abstract List<Products> findByIdAndMemberId(Products id, Member memberId);
	public abstract Optional<Products> findById(Products id);
	public abstract Optional<Products> findById(Integer id);
//	public abstract List<Product> findById(Long id);
	
//	public abstract List<Product> findByMemberId(List<Member> members);
//	public abstract List<Product> findBy

	
}
