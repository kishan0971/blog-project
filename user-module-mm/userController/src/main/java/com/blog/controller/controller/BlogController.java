package com.blog.controller.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.controller.response.ResponseHandler;
import com.blog.repository.DTO.BlogCreationRequest;
import com.blog.service.service.blogService.BlogService;

@RestController
@RequestMapping("/in2it/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping(path="/create", consumes =  { MediaType.MULTIPART_FORM_DATA_VALUE })
  
    public ResponseEntity<?> createBlog(@ModelAttribute  BlogCreationRequest blogCreationRequest) throws IOException {
        
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        String userName = authentication.getName();
       
        
        Map<String, Object> blog = blogService.createBlog(userName, blogCreationRequest);
        return ResponseHandler.responseBuilder("Blog Created SuccessFully", HttpStatus.OK,blog);
    }
}
