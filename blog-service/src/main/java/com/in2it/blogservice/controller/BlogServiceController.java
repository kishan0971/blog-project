package com.in2it.blogservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.in2it.blogservice.dto.BlogDto;
import com.in2it.blogservice.dto.BlogUpdateDto;
import com.in2it.blogservice.service.impl.BlogServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController

@RequestMapping("/in2it-blog")
public class BlogServiceController {
	@Autowired
	private BlogServiceImpl serviceImpl;

	/*
	 * This method is used to insert blog in database.
	 */

	@PostMapping(path = "/posts", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<?> saveBlogWithFile( @ModelAttribute BlogDto blogDto) {
		
		List<MultipartFile> media = blogDto.getMedia();

		BlogDto saveBlogWithFile = serviceImpl.saveBlogWithFile(blogDto,media);
		
		return ResponseEntity.status(HttpStatus.OK).body(saveBlogWithFile);
		
	}
	

	
	@PutMapping(path="/update/{updatedByUserId}" ,consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<BlogDto> updateBlog(@RequestBody  BlogUpdateDto updateDto, @Valid @PathVariable("updatedByUserId") String authorId) {

		return ResponseEntity.status(HttpStatus.OK).body(serviceImpl.updateBlog(updateDto, authorId));

	}
	
	@PutMapping("/updateLike")
	public ResponseEntity<BlogDto> updateLike(@RequestParam  Long blogId ,@RequestParam Long totalLikeCount) {
		return ResponseEntity.status(HttpStatus.OK).body(serviceImpl.updateLike(totalLikeCount, blogId));
	}
	
	@PutMapping("/updateComment")
	public ResponseEntity<BlogDto> updateComment(@RequestParam Long blogId ,@RequestParam Long totalCommentCount) {
		return ResponseEntity.status(HttpStatus.OK).body(serviceImpl.updateComment(totalCommentCount, blogId));
	}

	@DeleteMapping("/deleteByBlogId/{blogId}")
	public ResponseEntity<Boolean> deleteBlog(@PathVariable Long blogId , @RequestParam String userId) {
		
	
		return ResponseEntity.status(HttpStatus.OK).body(serviceImpl.deleteBlog(blogId,userId));
	
	}
	
	@DeleteMapping("/deleteByTitle/{title}")
	public ResponseEntity<Boolean> deleteBlogBytitle(@PathVariable String title,  @RequestParam String userId){
		return ResponseEntity.status(HttpStatus.OK).body(serviceImpl.deleteBlogByTitle(title, userId));
	}
	

	// pagination
	

	// pagination
	@GetMapping("/get")
     public	ResponseEntity<List<BlogDto>> getAllBlog() {
		
			return ResponseEntity.status(HttpStatus.OK).body(serviceImpl.getBlog());

	}

	// pagination

	@GetMapping("/getByUserId/{userId}")
	 public	ResponseEntity<List<BlogDto>> getBlogsByAutherId(@PathVariable @Valid String userId) {

			return ResponseEntity.status(HttpStatus.OK).body(serviceImpl.getByAutherID(userId));

	}
	
	
	@GetMapping("/getByBlogId/{blogId}")
	public ResponseEntity<BlogDto> getBlogById(@PathVariable(value = "blogId") @Valid Long blogId) {

	
			return ResponseEntity.status(HttpStatus.OK).body(serviceImpl.getBlogById(blogId));

	}

	
	// pagination
	@GetMapping("/getByTitle/{blogTitle}")
	public ResponseEntity<List<BlogDto>> getBlogByTitle(@PathVariable(value = "blogTitle")  String title) {


			return ResponseEntity.status(HttpStatus.OK).body(serviceImpl.getBlogTitle(title));
		

	}

}
