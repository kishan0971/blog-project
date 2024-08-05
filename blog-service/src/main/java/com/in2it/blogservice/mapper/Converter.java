package com.in2it.blogservice.mapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.in2it.blogservice.dto.BlogDto;
import com.in2it.blogservice.model.Blog;

@Component
public class Converter {


	public Blog dtoToBlogConverter(BlogDto dto,MultipartFile img,String mediaPath)
	{
		Blog blog=new Blog();
		blog.setContent(dto.getContent());
		blog.setAuthorId(dto.getAuthorId());
//		List<String> mediaNames=new ArrayList<>();
//		for(MultipartFile file:dto.getMedia())
//		{
//			mediaNames.add(file.getName());
//		}
//		
//		blog.setMedia(mediaNames);
		blog.setMedia(img.getOriginalFilename());
		blog.setTitle(dto.getTitle());
		blog.setVisiblity(dto.getVisiblity());
//		blog.setMediaPath(dto.getMediaPath());
//		blogDto.setCretedDateTime(LocalDateTime.now());
//		blogDto.setMediaPath(path1);
		blog.setMediaPath(mediaPath);
		
		//set to current date&time
		blog.setCretedDateTime(LocalDateTime.now());
//		blog.setCretedDateTime(dto.getCretedDateTime());
		
//		blog.setProjectId(author.getProjectId());
//		blog.setDepartmentId(author.getDepartmentId());
		blog.setProjectId(dto.getProjectId());
		blog.setDepartmentId(dto.getDepartmentId());
		//set to initial value 
//		blog.setLikeCount(0);
//		blog.setCommentCount(0);
		
		blog.setLikeCount(0);
		blog.setCommentCount(0);
		
		
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
		dto.setProjectId(blog.getProjectId());
		dto.setDepartmentId(blog.getDepartmentId());
		dto.setImg(getImage(blog.getMediaPath()));
		//set to current date&time
//		dto.setCretedDateTime(blog.getCretedDateTime());
		
		//set to initial value 
		dto.setLikeCount(blog.getLikeCount());
		dto.setCommentCount(blog.getCommentCount());
		
		
		
		return dto;
	}
	public byte[] getImage(String path)
	{
		byte[] img=null;
		try {
			img = Files.readAllBytes(new File(path).toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}
}



