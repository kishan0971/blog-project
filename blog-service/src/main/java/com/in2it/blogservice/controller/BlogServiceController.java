package com.in2it.blogservice.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

import com.in2it.blogservice.customException.InfoMissingException;
import com.in2it.blogservice.dto.BlogDto;
import com.in2it.blogservice.dto.BlogUpdateDto;
import com.in2it.blogservice.service.impl.BlogServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController

@RequestMapping("/in2it-blog")
public class BlogServiceController {
	@Autowired
	private BlogServiceImpl serviceImpl;

	/*
	 * This method is used to insert blog in database.
	 */

//	@PostMapping(path = "/posts", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
//	public ResponseEntity<?> saveBlogWithFile(@ModelAttribute BlogDto blogDto) {
//		List<MultipartFile> media = blogDto.getMedia();
//		BlogDto saveBlogWithFile = serviceImpl.saveBlogWithFile(blogDto, media);
//		
//		return ResponseEntity.status(HttpStatus.OK).body(saveBlogWithFile);
//	}
	
	
	@Tag(name = "called post-blog method", description = "After calling this method its return a map. ")
	@PostMapping(path = "/posts", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public Map<String, Object> saveBlogWithFile(@ModelAttribute BlogDto blogDto) {
	
		
		Map<String, Object> map= new HashMap<>();
		List<MultipartFile> media = blogDto.getMedia();
		BlogDto saveBlogWithFile = serviceImpl.saveBlogWithFile(blogDto, media);
		
		
		  map.put("blog", saveBlogWithFile);
		return map;
	}

	
	
	
	@PutMapping(path = "/update/{updatedByUserId}", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	@Operation(summary = "Update an blog", description = "Update an existing blog. Using blog blog id can update blog title ,content and vigibility.")
	public ResponseEntity<BlogDto> updateBlog(@RequestBody BlogUpdateDto updateDto,
			@Valid @PathVariable("updatedByUserId") String updatedBy) {

		return ResponseEntity.status(HttpStatus.OK).body(serviceImpl.updateBlog(updateDto, updatedBy));

	}

	@PutMapping("/updateLike")
	@Operation(summary = "update like count")
	public ResponseEntity<BlogDto> updateLike(@RequestParam UUID blogId, @RequestParam Long totalLikeCount) {
		return ResponseEntity.status(HttpStatus.OK).body(serviceImpl.updateLike(totalLikeCount, blogId));
	}

	@PutMapping("/updateComment")
	
	@Operation(summary = "update comment count")
	public ResponseEntity<BlogDto> updateComment(@RequestParam UUID blogId, @RequestParam Long totalCommentCount) {
		return ResponseEntity.status(HttpStatus.OK).body(serviceImpl.updateComment(totalCommentCount, blogId));
	}

	@DeleteMapping("/deleteByBlogId/{blogId}")
	@Operation(summary = "delete blog by blogId")
	public ResponseEntity<Boolean> deleteBlog(@PathVariable UUID blogId, @RequestParam String deletedBy) {

		return ResponseEntity.status(HttpStatus.OK).body(serviceImpl.deleteBlog(blogId, deletedBy));

	}

	@DeleteMapping("/deleteByTitle/{title}")
	@Operation(summary = "delete blog by title")
	public ResponseEntity<Boolean> deleteBlogBytitle(@PathVariable String title, @RequestParam UUID blogId) {
		return ResponseEntity.status(HttpStatus.OK).body(serviceImpl.deleteBlogByTitle(title, blogId));
	}

	// pagination

	// pagination
	@GetMapping("/get")
	@Operation(summary = "Get a all Blogs", description = "Returns  all blogs  ")
	public ResponseEntity<List<BlogDto>> getAllBlog() {
		return ResponseEntity.status(HttpStatus.OK).body(serviceImpl.getBlog());
	}

	// pagination

	@GetMapping("/getByAutherId/{autherId}")
	@Operation(summary = "Get a blog by autherId", description = "Returns a Blog as per the autherId.")
	public ResponseEntity<List<BlogDto>> getBlogsByAutherId(@PathVariable @Valid String autherId) {

		return ResponseEntity.status(HttpStatus.OK).body(serviceImpl.getByAutherID(autherId));

	}

	@GetMapping("/getByBlogId/{blogId}")
	@Operation(summary = "Get a blog by blogId", description = "Returns a blog as per the blogId.")
	public ResponseEntity<BlogDto> getBlogById(@PathVariable(value = "blogId") @Valid UUID blogId) {
		return ResponseEntity.status(HttpStatus.OK).body(serviceImpl.getBlogById(blogId));
	}

	// pagination
	@GetMapping("/getByTitle/{blogTitle}")
	@Operation(summary = "Get a blogs by blogTitle", description = "Returns a blogs as list by  blogTitle.")
	public ResponseEntity<List<BlogDto>> getBlogByTitle(@PathVariable(value = "blogTitle") String title) {
		if(title!=null) {
			
			return ResponseEntity.status(HttpStatus.OK).body(serviceImpl.getBlogTitle(title));
		}else {
			
			throw new InfoMissingException("please write valid info");
		}
	}
	
	
	@GetMapping("/getByTeamId/{teamId}")
	@Operation(summary = "Get a blog by teamId", description = "Returns a blog as per the teamId.")
	public ResponseEntity< List<BlogDto>> getByVisibility(@PathVariable long teamId){
		
		return ResponseEntity.status(HttpStatus.OK).body(serviceImpl.getByVisibility(teamId));
		
	}
	
	
	@GetMapping("/showAllVigibility")
	@Operation(summary = "Get a team vigibility ", description = "Returns a returs vigibility list.")
	public List<String> showVidibility(){
		
		List<String> visibility= Arrays.asList("TEAM","EVERYONE");
		
		return  visibility;
		
	}

}
