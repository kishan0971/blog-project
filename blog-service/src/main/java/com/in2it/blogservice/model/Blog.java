package com.in2it.blogservice.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long departmentId;
	private long projectId;
	@NotNull
	private long authorId;

	@NotNull
	private String title;
	@NotNull
	@Column(length = 5000)
	private String content;
	@NotNull
	private String visiblity;
	private int commentCount;
	private int likeCount;


//	private List<String> media;
	private String media;
	private String mediaPath;

	private LocalDateTime cretedDateTime;

	
//	private List<String> media;
	
//	private LocalDateTime cretedDateTime;
	
	
	private long deletedBy;
	

	 private String status;
	 
	 
	 
	 private String mediaFile;
	 
//	 private String mediaPath;

}
