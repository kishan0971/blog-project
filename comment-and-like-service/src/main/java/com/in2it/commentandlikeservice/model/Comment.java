package com.in2it.commentandlikeservice.model;

import jakarta.persistence.Entity;
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
	
	
	
	private Blog blog;
	
	private Author author;

}
