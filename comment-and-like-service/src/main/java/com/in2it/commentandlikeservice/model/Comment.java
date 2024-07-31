package com.in2it.commentandlikeservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
	
	private long id;
	private String content;
	private String media;
	private long blogId;
	private long authorID;
	
	
	@Transient
	private Blog blog;
	
	
	@Transient
	private Author author;

}
