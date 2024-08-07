package com.in2it.commentandlikeservice.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String content;
//	private String media;
	@NotNull
	private long blogId;
//	private long authorID;
	@NotNull
	private String userName;
	private Date date;
	private String status;
//	@Transient
//	private Blog blog;

//	@Transient
//	private Author author;
	private LocalDate createdDate;
	private String deletedBy;
	private LocalDate deletedAt;
	private	List<String> media;
	private List<String> mediaPath;

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
		this.createdDate = createdDate;
		this.deletedAt = deletedAt;
		this.deletedBy = deletedBy;

	}
	
	
}
