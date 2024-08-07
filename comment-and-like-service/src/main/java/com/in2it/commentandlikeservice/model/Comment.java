package com.in2it.commentandlikeservice.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
	public Comment(String content, String media, long blogId, String userName, Date date) {
		super();
		this.content = content;
		this.media = media;
		this.blogId = blogId;
//		this.authorID = authorID;
		this.userName = userName;
		this.date = date;
//		this.blog = blog;
//		this.author = author;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String content;
	private String media;
	private long blogId;
//	private long authorID;
	private String userName;
	private Date date;
//	@Transient
//	private Blog blog;
//	
//	
//	@Transient
//	private Author author;

}
