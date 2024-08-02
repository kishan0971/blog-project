package com.in2it.blogservice.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.in2it.blogservice.customException.IdInvalidException;
import com.in2it.blogservice.customException.UserNotFoundException;
import com.in2it.blogservice.dto.BlogDto;
import com.in2it.blogservice.mapper.Converter;
import com.in2it.blogservice.model.Blog;
import com.in2it.blogservice.repository.AuthorRepository;
import com.in2it.blogservice.repository.BlogRepository;
import com.in2it.blogservice.service.BlogService;

public class BlogServiceImpl implements BlogService {

	@Autowired
	private Converter objectMapper;

	@Autowired
	private BlogRepository repo;
	
	@Autowired
	private AuthorRepository authRepo;

	@Override
	public BlogDto saveBlog(BlogDto blogDto) {

		blogDto.setCretedDateTime(LocalDateTime.now());
		Blog blog = repo.save(objectMapper.dtoToBlogConverter(blogDto));

		return objectMapper.blogToDtoConverter(blog);
	}



	@Override
	public BlogDto updateBlog(BlogDto blogDto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteBlog(Long id) {
		return null;

	}

	@Override
	public List<BlogDto> getBlog(String title) {

		List<Blog> blog = repo.findByTitle(title);

		List<BlogDto> blogDtoList = new ArrayList<>();

		for (Blog blog2 : blog) {

			if (blog2 != null) {
				BlogDto blogToDtoConverter = objectMapper.blogToDtoConverter(blog2);
				blogDtoList.add(blogToDtoConverter);
			} else {
				throw new UserNotFoundException(
						HttpStatus.NO_CONTENT + "Content not avelable, please ! Try again.");
			}
		}

		return blogDtoList;
	}

	@Override
	public List<BlogDto> getBlog() {
		
		List<Blog> blog = repo.findAll();

		List<BlogDto> blogDtoList = new ArrayList<>();

		for (Blog blog2 : blog) {

			if (blog2 != null) {
				BlogDto blogToDtoConverter = objectMapper.blogToDtoConverter(blog2);
				blogDtoList.add(blogToDtoConverter);
			} else {
				throw new UserNotFoundException(
						HttpStatus.NO_CONTENT + "Content not avelable, please ! Try again.");
			}
		}

		return blogDtoList;
	}

	@Override
	public List<BlogDto> getByAutherName(String auther) {
//		
//	    List<Author> byFirstName = authRepo.findByFirstName(auther);
//		
//		List<BlogDto> blogDtoList=new  ArrayList<>();
//		
//		
//		
//		for (Author auth : byFirstName) {
//			
//			auth.getId()
//		}
//		
////		for (Blog blog2 : blog) {
////			
////			if(blog2!=null) {
////				BlogDto blogToDtoConverter = objectMapper.blogToDtoConverter(blog2);
////				blogDtoList.add(blogToDtoConverter);
////			}
////			else {
////				throw new UserNotFoundException(HttpStatus.NO_CONTENT + "Content not avelable, please ! Try again.");
////			}
////		}
//	
		return null;
	}

	@Override
	public BlogDto getBlog(Long id) {

		Blog blog = repo.findById(id).orElseThrow(() -> new IdInvalidException("Please ! correct id ."));
		if (blog != null) {
			BlogDto blogDto = objectMapper.blogToDtoConverter(blog);
			return blogDto;
		} else {
			throw new UserNotFoundException(
					HttpStatus.NO_CONTENT + "Content not avelable, please ! Try again.");
		}
	}
	
	
	

}
