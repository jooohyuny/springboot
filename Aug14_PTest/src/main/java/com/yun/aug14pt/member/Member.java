package com.yun.aug14pt.member;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name="member")
public class Member {
	@Id
	@Column(name="m_id")
	private String id;
	
	@Column(name="m_pw")
	private String password;
	
	@Column(name="m_name")
	private String name;

	@Column(name="m_birth")
	private Date date;
	
	@Column(name="m_loc")
	private String location;
	
	@Column(name="m_photo")
	private String photo;

	@Column(name="m_addr")
	private String address;
	
	@Column(name="m_admin")
	private Integer admin;
	
}
