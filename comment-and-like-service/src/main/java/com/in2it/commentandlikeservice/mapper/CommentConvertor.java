package com.in2it.commentandlikeservice.mapper;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.in2it.commentandlikeservice.dto.CommentDto;
import com.in2it.commentandlikeservice.model.Comment;

@Component
public class CommentConvertor {

	public Comment dtoToCommentConvertor(CommentDto commentDto) {
		Comment comment = new Comment(
				commentDto.getContent(), 
				commentDto.getMedia(),
				commentDto.getBlogId(), 
//				commentDto.getAuthorID(), 
				commentDto.getUserName(),
				commentDto.getDate()
//				commentDto.getBlog(),
//				commentDto.getAuthor()
				);
				comment.setDate(new Date());
				comment.setCreatedDate(LocalDate.now());
				comment.setDeletedAt(LocalDate.now());
				comment.setDeletedBy(commentDto.getDeletedBy());
				comment.setStatus("Active");
		return comment;
	}
	
	public CommentDto commentToDtoConvertor(Comment comment) {
		CommentDto commentDto = new CommentDto(
				comment.getId(), 
				comment.getContent(), 
				comment.getMedia(),
				comment.getBlogId(), 
				comment.getUserName(),
//				comment.getAuthorID(), 
				comment.getDate()
//				comment.getBlog(),
//				comment.getAuthor()
				);
				commentDto.setDate(new Date());
				commentDto.setStatus(comment.getStatus());
				commentDto.setCreatedDate(comment.getCreatedDate());
				commentDto.setDeletedAt(comment.getDeletedAt());
				commentDto.setDeletedBy(comment.getDeletedBy());
		return commentDto;
	}

}
