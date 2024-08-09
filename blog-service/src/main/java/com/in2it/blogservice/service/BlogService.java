package com.in2it.blogservice.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.in2it.blogservice.dto.BlogDto;
import com.in2it.blogservice.dto.BlogUpdateDto;
@Component
public interface BlogService {
	
	
//	BlogDto saveBlog(BlogDto blogDto);
	BlogDto	saveBlogWithFile(BlogDto blogDto,List<MultipartFile> multipartFile);
	
	BlogDto updateBlog(BlogUpdateDto updateDto, String updatedBy);
	BlogDto updateLike(Long totallikeCount ,Long id);
	BlogDto updateComment(Long totalCommentCount,Long id);
	
	Boolean deleteBlog(long id, String userId);
	Boolean deleteBlogByTitle(String title, long blogId);
	
	BlogDto getBlogById(Long id);
	List<BlogDto> getBlogTitle(String title);
	List<BlogDto> getBlog();
	List<BlogDto> getByAutherID(String userId);
	
	
	List<BlogDto> getByVisibility(long teamId);

}
