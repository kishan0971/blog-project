package com.in2it.commentandlikeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.in2it.commentandlikeservice.dto.CommentDto;
import com.in2it.commentandlikeservice.model.Comment;
import com.in2it.commentandlikeservice.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;


	@PostMapping(path = "/post", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<CommentDto> createComment(@ModelAttribute CommentDto commentDto){
		try {
			System.out.println("++++++++++");
			CommentDto createComment= commentService.saveComment(commentDto,commentDto.getFile());
			
			return ResponseEntity.status(HttpStatus.CREATED).body(createComment);
		}catch(Exception e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	}
	@GetMapping(path = "/get")
	public ResponseEntity<List<CommentDto>> getAllComment(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(commentService.getAllComment());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
