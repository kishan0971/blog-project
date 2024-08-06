package com.in2it.commentandlikeservice.model;

import java.util.Date;

import com.in2it.commentandlikeservice.dto.Author;
import com.in2it.commentandlikeservice.dto.Blog;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String content;
	private String media;
	private long blogId;
	private long authorID;
	private Date date;
	
	@Transient
	private Blog blog;
	
	
	@Transient
	private Author author;

}
