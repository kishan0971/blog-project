package com.in2it.blogservice.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
	private long id;
	private String title;
	private String content;

	
	
	private String visiblity;
	
	private int commentCount;
	private List<Like> likes = new ArrayList<>();
	
	private List<Comment> comments = new ArrayList<>();


	private LocalDateTime createdDate;



}
