package com.yun.project.member;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends CrudRepository<Member, String> {
	public abstract List<Member> findAll();
	public abstract Member findByIdEquals(String s);
	public abstract void deleteById(String s);
	boolean existsById(String id);
	
	public abstract Optional<Member> findById(Member m);
}
