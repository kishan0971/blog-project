package com.in2it.commentandlikeservice.dto;

import com.in2it.commentandlikeservice.model.Author;
import com.in2it.commentandlikeservice.model.Blog;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDto {
	
	private long id;
	private String content;
	private String media;
	private long blogId;
	private long authorID;
	
	
	
	private Blog blog;
	
	private Author author;

}
