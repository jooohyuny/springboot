package com.yun.project.product;

import java.time.LocalDateTime;

import com.yun.project.member.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Entity(name="purchase_history")
public class PurchaseHistory {
	@Id
    @SequenceGenerator(sequenceName = "purchase_seq", name="ps", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ps")
	@Column(name = "ph_id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "ph_p_id")
	private Products product;

	@ManyToOne
	@JoinColumn(name = "ph_m_id")
	private Member buyer;
}
