package com.yun.project.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yun.project.member.Member;

import java.util.List;



@Repository
public interface WishProductRepo extends CrudRepository<WishList, Integer>{
	public abstract List<WishList> findByMemberIdAndProductId(Member memberId, Products productId);
//	public abstract List<WishList> deleteByMemberIdAndProductId(Member memberId, Product productId);
//	public abstract List<WishList> findByMemberIdAndProductId(String memberId, Product productId);
//	public abstract List<WishList> deleteByMemberIdAndProductId(String memberId, Integer productId);
	public abstract List<WishList> findByMemberId(Member memberId);

}
