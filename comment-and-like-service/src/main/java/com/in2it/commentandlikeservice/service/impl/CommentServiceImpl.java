package com.in2it.commentandlikeservice.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in2it.commentandlikeservice.model.Comment;
import com.in2it.commentandlikeservice.repository.CommentRepository;
import com.in2it.commentandlikeservice.service.CommentService;


@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	public Comment saveComment(Comment comment){
		comment.setDate(new Date());
		return commentRepository.save(comment);
	}
	
}
