package com.in2it.commentandlikeservice.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
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
	@Hidden
	private String status;

	private LocalDate createdDate;
	@Hidden
	private String deletedBy;
	private LocalDate deletedAt;

	private List<String> mediaPath;

	/*
	 * private Blog blog; 
	 * private Author author;
	 */
	public CommentDto(long id, String content, String media, long blogId, String userName, Date date) {
		super();
		this.id = id;
		this.content = content;
		this.media = media;
		this.blogId = blogId;
//		this.authorID = authorID;
		this.userName = userName;
		this.date = date;
		/*
		 * this.blog = blog; this.author = author;
		 */
	}
	

}
