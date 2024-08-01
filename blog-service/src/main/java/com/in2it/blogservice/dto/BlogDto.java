package com.in2it.blogservice.dto;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BlogDto {
	
	
	private long id;
	private long departmentId;
	private long projectId;
	@Size(max = 50,min = 2,message = "title must not be longer than 50 characters and not be less than 3 characters")
	@NotBlank(message = "title cannot be blank") 
	private String title;
	@NotBlank(message = "content cannot be blank")
	private String content;
	private String visiblity;
	private int commentCount;
	private int likeCount;
	private String media;
	private long authorId;
	private LocalDateTime cretedDateTime;
	
	
}
