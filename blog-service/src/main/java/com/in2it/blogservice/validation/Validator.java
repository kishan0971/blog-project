package com.in2it.blogservice.validation;

import org.springframework.beans.factory.annotation.Autowired;

import com.in2it.blogservice.model.Author;
import com.in2it.blogservice.repository.AuthorRepository;

public class Validator {
	
	@Autowired
	private AuthorRepository authorRepo;
	
	public boolean validateAuthorId(long id)
	{
		Author author= authorRepo.getById(id);
		if(author==null)
			return false;
		else 
			return true;
	}
	public boolean validateProjectId(long id,int pId)
	{
		Author author= authorRepo.getById(id);
		if(author.get==null)
			return false;
		else 
			return true;
	}
}
