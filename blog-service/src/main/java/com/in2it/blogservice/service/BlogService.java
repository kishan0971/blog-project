package com.in2it.blogservice.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.in2it.blogservice.dto.BlogDto;
@Component
public interface BlogService {
	
	
	BlogDto saveBlog(BlogDto blogDto);
	BlogDto updateBlog(BlogDto blogDto, Long id);
	Boolean deleteBlog(Long id);
	Boolean deleteBlogByTitle(String title);
	
	BlogDto getBlogById(Long id);
	List<BlogDto> getBlogTitle(String title);
	List<BlogDto> getBlog();
	List<BlogDto> getByAutherID(long id);
	

}
