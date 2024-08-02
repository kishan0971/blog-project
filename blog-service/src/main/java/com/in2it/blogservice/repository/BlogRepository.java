package com.in2it.blogservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in2it.blogservice.model.Blog;


public interface BlogRepository extends JpaRepository<Blog, Long>{

	  
	  List<Blog> findByTitle(String title);
	
}
