package com.in2it.blogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Author {
	
	private long id;
	private String firstName;
	private String lastname;
	private String email;
	private String contactNumber;
	private String department;
	private long managerId;
	

}
