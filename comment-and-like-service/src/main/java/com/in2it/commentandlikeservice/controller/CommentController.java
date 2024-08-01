package com.in2it.commentandlikeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.in2it.commentandlikeservice.service.CommentService;

@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	
//	public ResponseEntity<?> createComment(){
//		
//	}
}
