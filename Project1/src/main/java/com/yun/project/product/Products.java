package com.yun.project.product;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.yun.project.member.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Product")
public class Products {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_generator")
    @SequenceGenerator(name = "product_seq_generator", sequenceName = "product_seq", allocationSize = 1)
	@Column(name="p_id")
	private Integer id;

    @ManyToOne
	@JoinColumn(name="p_m_id")
	private Member memberId;
	
	@Column(name="p_name")
	private String name;
	
	@Column(name="p_price")
	private Integer price;
	
	@Column(name="p_desc")
	private String desc;
	
	@Column(name="p_category")
	private String category;

	@Column(name="p_view")
	private Integer view;
	
	@Column(name="p_uploaddate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime uploadDate;
	
	@Column(name="p_updatedate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime updateDate;
	
	@Column(name="p_photo")
	private String photo;
	
	@Column(name="p_state")
	private String state; // 판매상태 -> 판매중 or 판매완료
	
	@Column(name = "p_loc")
	private String loc;
	
}
