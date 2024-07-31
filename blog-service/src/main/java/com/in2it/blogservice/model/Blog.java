package com.in2it.blogservice.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Blog {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private long id;
	private String title;
	private String content;
	private String visiblity;
	private int commentCount;
	private int likeCount;
	private String media;
	private String postedBy;
	private LocalDateTime cretedDateTime;

	
	
	
	


	



}
