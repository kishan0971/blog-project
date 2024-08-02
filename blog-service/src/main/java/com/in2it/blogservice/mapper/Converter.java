package com.in2it.blogservice.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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
		List<String> mediaNames=new ArrayList<>();
		for(MultipartFile file:dto.getMedia())
		{
			mediaNames.add(file.getName());
		}
		
		blog.setMedia(mediaNames);
		blog.setTitle(dto.getTitle());
		blog.setVisiblity(dto.getVisiblity());

		
		//set to current date&time
//		blog.setCretedDateTime(LocalDateTime.now());
		blog.setCreatedDateTime(dto.getCreatedDateTime());
		
//		blog.setProjectId(author.getProjectId());
//		blog.setDepartmentId(author.getDepartmentId());
		blog.setProjectId(dto.getProjectId());
		blog.setDepartmentId(dto.getDepartmentId());
		//set to initial value 
//		blog.setLikeCount(0);
//		blog.setCommentCount(0);
		
		blog.setLikeCount(dto.getLikeCount());
		blog.setCommentCount(dto.getCommentCount());
		
		
		return blog;
	}
	
	public BlogDto blogToDtoConverter(Blog blog)
	{
		BlogDto dto=new BlogDto();
		dto.setId(blog.getId());
		dto.setContent(blog.getContent());
		dto.setAuthorId(blog.getAuthorId());
//		dto.setMedia (blog.getMedia());
		dto.setTitle(blog.getTitle());
		dto.setVisiblity(blog.getVisiblity());

		//set to current date&time
		dto.setCreatedDateTime(blog.getCreatedDateTime());
		
		//set to initial value 
		dto.setLikeCount(blog.getLikeCount());
		dto.setCommentCount(blog.getCommentCount());
		
		
		
		return dto;
	}
}



