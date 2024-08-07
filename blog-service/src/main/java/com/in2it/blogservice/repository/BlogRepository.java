package com.in2it.blogservice.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.in2it.blogservice.model.Blog;




@Repository
public interface BlogRepository extends JpaRepository<Blog, Long>{
    

	@Query(value= "select  * from blog where status='Active' and title =%:title% ", nativeQuery = true)
	 List<Blog> findByTitle(String title);
	
	@Query(value= "select  * from blog where status='Active' and author_id =%:authorId% ", nativeQuery = true)
	 List<Blog> findByAuthorId(long authorId);
	

	@Query(value= "select  * from blog where status='Active'", nativeQuery = true)
	 List<Blog> findAll();
	
	@Query(value= "select  * from blog where id=%:id% and status='Active'", nativeQuery = true)
	Blog getByBlogId(long id);
		
	
	@Modifying
	@Query(value= "update  blog set  status='InActive', deleted_by=%:userId%  , deleted_date_time=%:time% where  id=%:id%", nativeQuery = true)
	 void deleteBlogById(long id , long userId ,LocalDateTime time);
	
	@Modifying
	@Query(value= "update  blog set  status='InActive', deleted_by=%:userId%  , deleted_date_time=%:time% where  title=%:title%", nativeQuery = true)
	void deleteBytitle(String title, long userId ,LocalDateTime time);
	
}
