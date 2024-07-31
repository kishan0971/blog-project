package com.in2it.commentandlikeservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Like {
	
	private long id;
	private Blog blog;
	
	@OneToOne
	private Author author;
	

}
