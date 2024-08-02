package com.in2it.blogservice.mapper;

import com.in2it.blogservice.dto.BlogDto;
import com.in2it.blogservice.model.Blog;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Converter {

	public Blog dtoToBlogConverter(BlogDto dto)
	{
		Blog blog=new Blog();
		blog.setContent(dto.getContent());
		blog.setAuthorId(dto.getAuthorId());
		blog.setMedia(dto.getMedia());
		blog.setTitle(dto.getTitle());
		blog.setVisiblity(dto.getVisiblity());

		//set to current date&time
//		blog.setCretedDateTime(LocalDateTime.now());
		blog.setCreatedDateTime(dto.getCreatedDateTime());
		
		//set to initial value 
//		blog.setLikeCount(0);
//		blog.setCommentCount(0);
		
		blog.setLikeCount(dto.getLikeCount());
		blog.setCommentCount(dto.getCommentCount());
		blog.setDepartmentId(dto.getDepartmentId());
		blog.setProjectId(dto.getProjectId());
		
		return blog;
	}
	
	public BlogDto blogToDtoConverter(Blog blog)
	{
		BlogDto dto=new BlogDto();
		dto.setId(blog.getId());
		dto.setContent(blog.getContent());
		dto.setAuthorId(blog.getAuthorId());
		dto.setMedia(blog.getMedia());
		dto.setTitle(blog.getTitle());
		dto.setVisiblity(blog.getVisiblity());

		//set to current date&time
		dto.setCreatedDateTime(blog.getCreatedDateTime());
		
		//set to initial value 
		dto.setLikeCount(blog.getLikeCount());
		dto.setCommentCount(blog.getCommentCount());
		dto.setDepartmentId(blog.getDepartmentId());
		dto.setProjectId(blog.getProjectId());
		
		
		return dto;
	}
}



