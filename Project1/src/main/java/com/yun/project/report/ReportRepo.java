package com.yun.project.report;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import com.yun.project.member.Member;


@Repository
public interface ReportRepo extends CrudRepository<Report, String>{
	public abstract List<Report> findByWriterId(Member writerId);
	
	public abstract Optional<Report> findById(Integer id);
}
