package com.in2it.blogservice.service;

import java.util.List;

import com.in2it.blogservice.dto.BlogDto;

public interface BlogService {
	
	
	BlogDto saveBlog(BlogDto blogDto);
	BlogDto getByid(int id);
	BlogDto updateBlog(BlogDto blogDto, int id);
	BlogDto getBlogByTitle(String title);
	List<BlogDto> getAllBlog();
	void deleteBlog(int id);
	

}
