package com.in2it.blogservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in2it.blogservice.customException.IdInvalidException;
import com.in2it.blogservice.customException.InfoMissingException;
import com.in2it.blogservice.customException.UserNotFoundException;
import com.in2it.blogservice.dto.BlogDto;
import com.in2it.blogservice.mapper.Converter;
import com.in2it.blogservice.model.Blog;
import com.in2it.blogservice.repository.BlogRepository;
import com.in2it.blogservice.service.BlogService;

import jakarta.transaction.Transactional;

@Service
@Component
@Transactional
public class BlogServiceImpl implements BlogService {

	@Autowired
	private Converter objectMapper;

	@Autowired
	private BlogRepository repo;
//	@Autowired
//	private AuthorRepository authorRepo;
	
	
	public BlogDto saveBlogWithFile(BlogDto blogDto, MultipartFile multipartFile) {
		Blog blog=null;
		if(!multipartFile.isEmpty() && blogDto!=null) {
			
			String uploadFilePath = objectMapper.uploadFile(multipartFile);
			String originalFilename = multipartFile.getOriginalFilename();
			
			Blog dtoToBlogConverter = objectMapper.dtoToBlogConverter(blogDto, originalFilename, uploadFilePath);
			
			String uriString = ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(multipartFile.getOriginalFilename()).toUriString();
			dtoToBlogConverter.setMediaPath(uriString);
			
		    blog= repo.save(dtoToBlogConverter);
		}
	
		 return objectMapper.blogToDtoConverter(blog);
		
	}
	

	@Override
	public BlogDto updateBlog(BlogDto blogDto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteBlog(Long id) {
		
		if(id>0) {
		 repo.deleteBlogById(id);

		return	true;
		}
		else {
		
			throw new IdInvalidException(HttpStatus.NO_CONTENT  + "id not found, Please ! enter correct id.");
		}
		

	}


	@Override
	public Boolean deleteBlogByTitle(String title) {
		
		if(title!=null) {
			repo.deleteBytitle(title);
			return	true;
		}
		else {
			
			throw new InfoMissingException(HttpStatus.NO_CONTENT  + " Data not found, Please ! try again .");
		}
	}
	
	@Override
	public List<BlogDto> getBlogTitle(String title) {

		List<Blog> blog = repo.findByTitle(title);

		List<BlogDto> blogDtoList = new ArrayList<>();

		for (Blog blog2 : blog) {

			if (blog2 != null) {
				BlogDto blogToDtoConverter = objectMapper.blogToDtoConverter(blog2);
				
				blogDtoList.add(blogToDtoConverter);
			} else {
				throw new UserNotFoundException(
						HttpStatus.NO_CONTENT + " Data not available, please ! Try again.");
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
						HttpStatus.NO_CONTENT + " Data not available, please ! Try again.");
			}
		}

		return blogDtoList;
	}



	public List<BlogDto> getByAutherID(long id) {
		
		List<Blog> byAuthorId = repo.findByAuthorId(id);
		
		List<BlogDto> blogDtoList = new ArrayList<>();

		for (Blog blog2 : byAuthorId) {

			if (blog2 != null) {
				BlogDto blogToDtoConverter = objectMapper.blogToDtoConverter(blog2);
				blogDtoList.add(blogToDtoConverter);
			} else {
				throw new UserNotFoundException(
						HttpStatus.NO_CONTENT + "  Data not available, please ! Try again.");
			}
		}
		
		return blogDtoList;
	}

	@Override
	public BlogDto getBlogById(Long id) {

		
		Blog blog = repo.getByBlogId(id);
		if (blog != null) {
			BlogDto blogDto = objectMapper.blogToDtoConverter(blog);
			return blogDto;
		} else {
			throw new UserNotFoundException(
					HttpStatus.NO_CONTENT + "   Data not available, please ! Try again.");
		}
	}




	
	
	

}
