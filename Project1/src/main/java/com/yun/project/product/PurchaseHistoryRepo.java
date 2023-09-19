package com.yun.project.product;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.yun.project.member.Member;


public interface PurchaseHistoryRepo extends JpaRepository<PurchaseHistory, Integer>{

	public abstract List<PurchaseHistory> findByBuyer(Member buyer);

}
