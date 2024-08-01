package com.in2it.blogservice.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
=======
>>>>>>> 4eb7335e8605256c91648e3be1d3602a7172f93d
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
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private long id;
	private long departmentId;
	private long projectId;
	@NotNull
	private String title;
	@NotNull
	private String content;
	@NotNull
	private String visiblity;
	private int commentCount;
	private int likeCount;
	private String media;
<<<<<<< HEAD
	@NotNull
	private String postedBy;
=======
	private long authorId;
>>>>>>> 4eb7335e8605256c91648e3be1d3602a7172f93d
	private LocalDateTime cretedDateTime;

	
	
	
	


	



}
