package com.in2it.blogservice.service;

import java.util.List;

import com.in2it.blogservice.dto.BlogDto;

public interface BlogService {
	
	
	BlogDto saveBlog(BlogDto blogDto);
	BlogDto updateBlog(BlogDto blogDto, Long id);
	Boolean deleteBlog(Long id);
	
	BlogDto getBlog(Long id);
	List<BlogDto> getBlog(String title);
	List<BlogDto> getBlog();
	List<BlogDto> getByAutherName(String auther);
	

}
