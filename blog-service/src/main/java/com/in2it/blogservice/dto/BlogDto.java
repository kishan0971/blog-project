package com.in2it.blogservice.dto;


import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BlogDto {
	
	
	private Long id;
	private String title;
	private String content;
	private String media;
	
	private LocalDateTime createdDate;
	

}
