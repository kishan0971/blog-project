package com.in2it.commentandlikeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in2it.commentandlikeservice.model.Comment;
import com.in2it.commentandlikeservice.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@PostMapping
	public ResponseEntity<?> createComment(@RequestBody Comment comment){
		try {
			Comment createComment= commentService.saveComment(comment);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(createComment);
		}catch(Exception e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	}
}
