package com.in2it.commentandlikeservice.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDto {
	
	private long id;
	private String content;
	@JsonIgnore
	private String media;
	private long blogId;
//	private long authorID;
	private String userName;
	@JsonIgnore
	private Date date;
	@JsonIgnore
	private MultipartFile file;
	
	
	public CommentDto(long id, String content, String media, long blogId,
			 String userName, Date date) {
		super();
		this.id = id;
		this.content = content;
		this.media = media;
		this.blogId = blogId;
//		this.authorID = authorID;
		this.userName = userName;
		this.date = date;
		/*this.blog = blog;
		this.author = author;*/
	}
/*	private Blog blog;
	private Author author;*/

}
