package com.in2it.blogservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.in2it.blogservice.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>
{
	
}