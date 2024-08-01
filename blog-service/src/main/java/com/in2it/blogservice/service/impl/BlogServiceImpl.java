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


<<<<<<< HEAD
=======

>>>>>>> 9b112ccaf923904d2fb2e81bc31281c8dfef18f1
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
<<<<<<< HEAD
	
//	public Blog dtoToBlogConverter(BlogDto dto)
//	{
//		Blog blog=new Blog();
//		blog.se
//	}
=======


	

//	@Override
//	public List<BlogDto> getBlogByTitle(String title) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public BlogDto getBlogByid(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
>>>>>>> 9e063c74ec9f5300c7793f29b18bd39f189091d1


}
