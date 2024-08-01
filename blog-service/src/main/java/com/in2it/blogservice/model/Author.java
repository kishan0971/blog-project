package com.in2it.blogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Author {
	
	private long id;
	private String UserName;
	private String email;
	private String contactNumber;
	private String department;
	private long managerId;
	

}
