package com.in2it.commentandlikeservice.model;

import com.in2it.commentandlikeservice.dto.Author;
import com.in2it.commentandlikeservice.dto.Blog;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
	@Id
	@GeneratedValue
	private long id;
	private long blogId;
	private long authorId;

	@Transient
	private Blog blog;
	@Transient
	private Author author;
	

}
