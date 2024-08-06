package com.in2it.commentandlikeservice.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.in2it.commentandlikeservice.dto.CommentDto;
import com.in2it.commentandlikeservice.model.Comment;
import com.in2it.commentandlikeservice.repository.CommentRepository;
import com.in2it.commentandlikeservice.service.CommentService;
import com.in2it.commentandlikeservice.service.FileService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private FileService fileService;

	public Comment saveComment(CommentDto commentDto, MultipartFile file) {

//		String fileName = null;
//		if (file != null && file.isEmpty()) {
//			try {
//				fileName = fileService.uploadImage(file);
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw new RuntimeException("File upload failed");
//			}
//		}
	
		Comment comment = new Comment(commentDto.getId(), commentDto.getContent(), commentDto.getMedia(),
				commentDto.getBlogId(), commentDto.getAuthorID(), commentDto.getDate(), commentDto.getBlog(),
				commentDto.getAuthor());
		comment.setDate(new Date());

		try {
			 String uploadImage = fileService.uploadImage(file);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return commentRepository.save(comment);
	}

	public List<Comment> getAllComment() {
		return commentRepository.findAll();
	}

}
