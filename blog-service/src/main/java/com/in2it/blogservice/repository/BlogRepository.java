package com.in2it.blogservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.in2it.blogservice.model.Blog;
<<<<<<< HEAD
@Repository
public interface BlogRepository extends JpaRepository<Blog, Long>{
    

=======




@Repository
public interface BlogRepository extends JpaRepository<Blog, Long>{
    

>>>>>>> c4e4e9173a64ca1834c01a85800ccc820f548de7
	@Query(value= "select  * from blog where status='Active' and title =%:title% ", nativeQuery = true)
	 List<Blog> findByTitle(String title);
	
	@Query(value= "select  * from blog where status='Active' and author_id =%:authorId% ", nativeQuery = true)
	 List<Blog> findByAuthorId(long authorId);
	

	@Query(value= "select  * from blog where status='Active'", nativeQuery = true)
	 List<Blog> findAll();
	
	@Query(value= "select  * from blog where id=%:id% and status='Active'", nativeQuery = true)
	Blog getByBlogId(long id);
		
	
	@Modifying
	@Query(value= "update  blog set  status='InActive' where  id=%:id%", nativeQuery = true)
	 void deleteBlogById(Long id);
	
	@Modifying
<<<<<<< HEAD
	@Query(value= "update  blog set  status='InActive' where  id=%:title%", nativeQuery = true)
	void deleteBytitle(String title);
	
}
=======
	@Query(value= "update  blog set  status='InActive' where  title=%:title%", nativeQuery = true)
	void deleteBytitle(String title);
	
}
>>>>>>> c4e4e9173a64ca1834c01a85800ccc820f548de7
