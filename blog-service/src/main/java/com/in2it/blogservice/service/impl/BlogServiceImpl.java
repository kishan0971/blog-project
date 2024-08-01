package com.in2it.blogservice.service.impl;

import java.util.List;

import com.in2it.blogservice.dto.BlogDto;
import com.in2it.blogservice.model.Blog;
import com.in2it.blogservice.service.BlogService;

public class BlogServiceImpl implements BlogService {

	@Override
	public BlogDto saveBlog(BlogDto blogDto) {
		
		
		return null;
	}

	@Override
	public BlogDto updateBlog(BlogDto blogDto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBlog(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BlogDto getByid(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogDto> getBlogByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogDto> getAllBlog() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogDto> getByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public Blog dtoToBlogConverter(BlogDto dto)
//	{
//		Blog blog=new Blog();
//		blog.se
//	}


}
