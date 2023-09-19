package com.yun.project.report;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.cglib.core.RejectModifierPredicate;
import org.springframework.stereotype.Service;

import com.yun.project.member.Member;

import jakarta.servlet.http.HttpServletRequest;


@Service
public class ReportDAO {

	@Autowired
	private ReportRepo rr;
	
	
	public void getReport(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		try {
			
			List<Report> r = rr.findByWriterId(m);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			for (Report report : r) {
				LocalDateTime timestamp = report.getDate();
			    String formattedDate = timestamp.format(formatter);
			    report.setReportTimestampFormatted(formattedDate);
			}
			
			req.setAttribute("report", r);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getReportDetail(HttpServletRequest req, Integer rId) {
		try {
			Optional<Report> rOptional = rr.findById(rId);
			if (rOptional.isPresent()) {
				Report report = rOptional.get();
				req.setAttribute("reportDetail", report);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
