package com.in2it.commentandlikeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.in2it.commentandlikeservice.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	
	List<Comment> findByBlogId(long blogId);
	
	@Query(value= "select  * from comment where status='Active'", nativeQuery = true)
	 List<Comment> findAll();
}
