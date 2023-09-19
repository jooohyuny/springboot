package com.kim.aug17nb.townnews;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data	
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="townnews")

public class TownNews {
	
	@Id
    @SequenceGenerator(sequenceName = "townnews_seq", name = "stn", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stn")
	@Column(name = "t_id") 
	private Integer townNewsNum;
	
	@Column(name = "t_m_id") 
	private String townNewsMemberId;
	
	@Column(name = "t_title") 
	private String townNewsTitle;
	
	@Column(name = "t_text") 
	private String townNewsText;
	
	@Column(name = "t_photo") 	
	private String townNewsPhoto;
	
    @Column(name = "t_date")
    private LocalDateTime townNewsTimestamp; // 날짜와 시간 정보를 모두 다룸
    
    @PrePersist
    @PreUpdate
    public void beforePersist() {
        LocalDateTime now = LocalDateTime.now();
        // Create a custom DateTimeFormatter to format the LocalDateTime without seconds
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = now.format(formatter);
        townNewsTimestamp = LocalDateTime.parse(formattedDateTime, formatter);
    }
	
}
