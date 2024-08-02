package com.in2it.blogservice.controller;

import java.util.ArrayList;
import java.util.List;

import com.in2it.blogservice.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
	private BlogService serviceImpl;

	/*
	 * This method is used to insert blog in database.
	 */
	@PostMapping("/post")
	public ResponseEntity<BlogDto> saveBlog( @RequestBody BlogDto blogDto) {

		if (blogDto != null) {
			return ResponseEntity.status(HttpStatus.OK).body(serviceImpl.saveBlog(blogDto));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(serviceImpl.saveBlog(blogDto));
		}

	}

	@PutMapping("/update")
	public ResponseEntity<BlogDto> updateBlog(@RequestBody BlogDto blogDto, @Valid @PathVariable Long id) {

		if (blogDto != null || id > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(serviceImpl.updateBlog(blogDto, id));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(serviceImpl.updateBlog(blogDto, id));
		}

	}

	@DeleteMapping("/delete")
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

			return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

	}

	// pagination
	@GetMapping("/get/{blogTitle}")
	public ResponseEntity<?> getBlog(@PathVariable(value = "blogTitle") @Valid String title) {

		List<BlogDto> blog = serviceImpl.getBlog(title);
		
		if(!blog.isEmpty()) {

			return ResponseEntity.status(HttpStatus.OK).body(blog);
		} else {
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ArrayList<>());
		}

	}

	// pagination
	@GetMapping("/get")
     public	ResponseEntity<?> getBlog() {
		List<BlogDto> blog = serviceImpl.getBlog();
		if(!blog.isEmpty()) {

			return ResponseEntity.status(HttpStatus.OK).body(blog);

		} else{

			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ArrayList<>());
		}
	}

	// pagination
	@GetMapping("/get/{userName}")
	 public	ResponseEntity<?> getByAutherName(@PathVariable @Valid String userName) {
		
		List<BlogDto> byAutherName = serviceImpl.getByAutherName(userName);
		
		if(!byAutherName.isEmpty()) {

			return ResponseEntity.status(HttpStatus.OK).body(byAutherName);

		} else{

			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ArrayList<>());
		}

	}

}
