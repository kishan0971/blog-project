package com.in2it.blogservice.model;

import java.util.Date;

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
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String content;
	private String media;
	private long blogId;
	private long authorID;
	private Date date;



}
