package com.in2it.blogservice.service;

import java.util.List;

import com.in2it.blogservice.dto.BlogDto;

public interface BlogService {
	
	
	BlogDto saveBlog(BlogDto blogDto);
	BlogDto updateBlog(BlogDto blogDto, Long id);
	void deleteBlog(Long id);
	BlogDto getBlogByid(Long id);
	List<BlogDto> getBlogByTitle(String title);
	List<BlogDto> getAllBlog();
	List<BlogDto> getByUserName(String userName);
	

}
