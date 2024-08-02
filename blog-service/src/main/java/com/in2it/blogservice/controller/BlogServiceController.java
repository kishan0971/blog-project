package com.in2it.blogservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in2it.blogservice.dto.BlogDto;
import com.in2it.blogservice.service.impl.BlogServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/in2it-blog")
public class BlogServiceController {

	private BlogServiceImpl serviceImpl;

	/*
	 * This method is used to insert blog in database.
	 */

	@PostMapping(path = "/auther/{authId}/department/{departmentId}/project/{teamId}/posts", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<BlogDto> saveBlog( @ModelAttribute BlogDto blogDto,
			                                 @PathVariable long authId,
			                                 @PathVariable long departmentId,
			                                 @PathVariable long teamId
			                                ) {

		if (blogDto != null) {
			
			blogDto.setAuthorId(authId);
			blogDto.setDepartmentId(departmentId);
			blogDto.setProjectId(teamId);
			return ResponseEntity.status(HttpStatus.OK).body(serviceImpl.saveBlog(blogDto));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(serviceImpl.saveBlog(blogDto));
		}

	}

	
	@PutMapping(path="/auther/{authId}/update" ,consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<BlogDto> updateBlog(@RequestBody BlogDto blogDto, @Valid @PathVariable("authId") Long id) {

		if (blogDto != null || id > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(serviceImpl.updateBlog(blogDto, id));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(serviceImpl.updateBlog(blogDto, id));
		}

	}

	@DeleteMapping("/auther/{authId}/delete")
	public ResponseEntity<?> deleteBlog(@PathVariable @Valid Long id) {
		Boolean deleteBlog = serviceImpl.deleteBlog(id);
		
		if(deleteBlog)
		{
			return ResponseEntity.status(HttpStatus.OK).body(true);
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(false);
		}
		
	}

	// pagination
	@GetMapping("/get/{blogId}")
	public ResponseEntity<BlogDto> getBlog(@PathVariable(value = "blogId") @Valid Long id) {

		BlogDto blog = serviceImpl.getBlog(id);
		
		if(blog!=null) {

			return ResponseEntity.status(HttpStatus.OK).body(blog);

		} else {

			return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}

	}

	// pagination
	@GetMapping("/get/{blogTitle}")
	public ResponseEntity<List<BlogDto>> getBlog(@PathVariable(value = "blogTitle") @Valid String title) {

		List<BlogDto> blog = serviceImpl.getBlog(title);
		
		if(!blog.isEmpty()) {

			return ResponseEntity.status(HttpStatus.OK).body(blog);
		} else {
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ArrayList<>());
		}

	}

	// pagination
	@GetMapping("/get")
     public	ResponseEntity<List<BlogDto>> getBlog() {
		List<BlogDto> blog = serviceImpl.getBlog();
		if(!blog.isEmpty()) {

			return ResponseEntity.status(HttpStatus.OK).body(blog);

		} else{

			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ArrayList<>());
		}
	}

	// pagination
	@GetMapping("/get/{userName}")
	 public	ResponseEntity<List<BlogDto>> getByAutherName(@PathVariable @Valid String userName) {
		
		List<BlogDto> byAutherName = serviceImpl.getByAutherName(userName);
		
		if(!byAutherName.isEmpty()) {

			return ResponseEntity.status(HttpStatus.OK).body(byAutherName);

		} else{

			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ArrayList<>());
		}

	}

}
