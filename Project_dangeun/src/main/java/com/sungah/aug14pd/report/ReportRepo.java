package com.sungah.aug14pd.report;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReportRepo extends CrudRepository<Report, String>{
}
