package com.in2it.commentandlikeservice.dto;

import java.util.Date;

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
	private Date date;
	
	
	private Blog blog;
	
	private Author author;

}
