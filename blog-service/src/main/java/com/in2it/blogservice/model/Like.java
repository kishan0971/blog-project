package com.in2it.blogservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor

@Data
public class Like {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long blogId;
	private long authorId;

}
