package com.in2it.blogservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in2it.blogservice.model.Blog;


@Repository
public interface BlogRepository extends JpaRepository<Blog, Long>{

	  
	  List<Blog> findByTitle(String title);
	 List<Blog> findByAuthorId(long authorId);
}
