package com.in2it.blogservice.model;

import java.time.LocalDateTime;
import java.util.List;

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
	private String content;
	@NotNull
	private String visiblity;
	
	private long commentCount;
	private long likeCount;
	
//	private List<String> media;
	
	
	
	private long deletedBy;
	private long updatedBy;
	
	

	 private String status;
	 
	 private LocalDateTime cretedDateTime;
	 private LocalDateTime updatedDateTime;
	 private LocalDateTime deletedDateTime;
	 
	 private List<String> mediaFile;
	 
	 private List<String> mediaPath;
}
