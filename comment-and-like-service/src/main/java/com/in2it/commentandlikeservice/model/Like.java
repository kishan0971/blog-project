package com.in2it.commentandlikeservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Like {
	
	private long id;
	private long blogId;
	private long authorId;

	@Transient
	private Blog blog;
	@Transient
	private Author author;
	

}
