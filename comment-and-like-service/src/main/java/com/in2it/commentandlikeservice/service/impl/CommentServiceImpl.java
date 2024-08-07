package com.in2it.commentandlikeservice.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.in2it.commentandlikeservice.dto.CommentDto;
import com.in2it.commentandlikeservice.mapper.CommentConvertor;
import com.in2it.commentandlikeservice.model.Comment;
import com.in2it.commentandlikeservice.repository.CommentRepository;
import com.in2it.commentandlikeservice.service.CommentService;
import com.in2it.commentandlikeservice.service.FileService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private CommentConvertor objectMapper;
	@Autowired
	private FileService fileService;

	public CommentDto saveComment(CommentDto commentDto, MultipartFile file) {

//		Comment comment=objectMapper.dtoToCommentConvertor(commentDto);
		Comment comment = objectMapper.dtoToCommentConvertor(commentDto);
		String uploadImage = null;
		try {
			uploadImage = fileService.uploadImage(file);

		} catch (Exception e) {

			e.printStackTrace();
		}
		comment.setMedia(uploadImage);
		Comment com = commentRepository.save(comment);
		CommentDto dto = objectMapper.commentToDtoConvertor(comment);
		return dto;
	}

	
	public List<CommentDto> getAllComment() {
		List<Comment> commentList=commentRepository.findAll();
		List<CommentDto> commentDtoList=new ArrayList<>();
		for(Comment com: commentList) {
			if(com != null) {
				CommentDto commentDtoConvertor=objectMapper.commentToDtoConvertor(com);
				commentDtoList.add(commentDtoConvertor);
			}
		}
		return commentDtoList;
	}
	
	
	public List<CommentDto> getByBlogId(Long id){
		List<Comment> commentList=commentRepository.findByBlogId(id);
		List<CommentDto> commentListDto=new ArrayList<>();
		for(Comment com:commentList) {
			if(com != null) {
				CommentDto commentDtoConvertor= objectMapper.commentToDtoConvertor(com);
				commentListDto.add(commentDtoConvertor);
			}
		}
		return commentListDto;
	}

}
