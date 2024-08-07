package com.in2it.blogservice.service;

import java.util.List;

<<<<<<< HEAD
import org.springframework.web.multipart.MultipartFile;

import com.in2it.blogservice.dto.BlogDto;
=======
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
>>>>>>> c4e4e9173a64ca1834c01a85800ccc820f548de7

import com.in2it.blogservice.dto.BlogDto;
@Component
public interface BlogService {
	
	
<<<<<<< HEAD
	BlogDto saveBlog(BlogDto blogDto,MultipartFile img);
=======
//	BlogDto saveBlog(BlogDto blogDto);
	BlogDto	saveBlogWithFile(BlogDto blogDto,MultipartFile img);
>>>>>>> c4e4e9173a64ca1834c01a85800ccc820f548de7
	BlogDto updateBlog(BlogDto blogDto, Long id);
	Boolean deleteBlog(Long id);
	Boolean deleteBlogByTitle(String title);
	
<<<<<<< HEAD

=======
	BlogDto getBlogById(Long id);
	List<BlogDto> getBlogTitle(String title);
>>>>>>> c4e4e9173a64ca1834c01a85800ccc820f548de7
	List<BlogDto> getBlog();
	List<BlogDto> getByAutherID(long id);
	List<BlogDto> getBlogTitle(String title);
	BlogDto getBlogById(Long id);
	
	

}
