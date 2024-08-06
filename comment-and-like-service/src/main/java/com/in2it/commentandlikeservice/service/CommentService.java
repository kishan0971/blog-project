package com.in2it.commentandlikeservice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.in2it.commentandlikeservice.dto.CommentDto;
import com.in2it.commentandlikeservice.model.Comment;

public interface CommentService {

	public Comment saveComment(CommentDto commentDto, MultipartFile file);
	public List<Comment> getAllComment();
	
	
}
