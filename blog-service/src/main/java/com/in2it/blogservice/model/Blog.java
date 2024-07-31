package com.in2it.blogservice.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Blog {
	
	@Id
	private long id;
	private String title;
	private String content;
	private String media;
<<<<<<< HEAD
	
	
	private String visiblity;
	
	private int commentCount;
	private List<Like> likes = new ArrayList<>();
	
	private List<Comment> comments = new ArrayList<>();

=======
	private LocalDateTime createdDate;
>>>>>>> 261d430e013683ec9a3aa00c15b296f86f28bfd5


}
