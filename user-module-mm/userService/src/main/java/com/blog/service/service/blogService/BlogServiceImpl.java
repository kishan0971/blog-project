package com.blog.service.service.blogService;

import com.blog.repository.DTO.BlogCreationFeignClient;
import com.blog.repository.DTO.BlogCreationRequest;
import com.blog.repository.entity.User;
import com.blog.repository.repository.UserRepository;
import com.blog.service.exceptions.DepartmentNotFoundException;
import com.blog.service.exceptions.TeamNotFoundException;
import com.blog.service.externalServices.ExternalBlogService;
import com.blog.service.helper.BlogHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogHelper blogHelper;

    @Autowired
    private BlogCreationFeignClient blogCreationClient;

    @Autowired
    private ExternalBlogService externalBlogService;

    @Override
    public Map<String, Object> createBlog(String creator, BlogCreationRequest blogCreationRequest) throws IOException {
    	
        try {
//            blogHelper.checkExistenceOfTeam(blogCreationRequest.getTeam_visibility());
//            blogHelper.checkExistenceOfDepartment(blogCreationRequest.getDepartment_visibility());
  
          
            User sender = userRepository.findByUserName(creator);
            
        
            
//            blogCreationClient.setUserId(sender.getId());
            blogCreationClient.setAuthorId(sender.getUserName());
            blogCreationClient.setTitle(blogCreationRequest.getTitle());
            blogCreationClient.setContent(blogCreationRequest.getContent());
            blogCreationClient.setTeamId(blogCreationRequest.getTeamId());
            blogCreationClient.setDepartmentId(blogCreationRequest.getDepartmentId());
            
            List<MultipartFile> files = blogCreationRequest.getMedia();
            
            System.out.println("my files ==========="+blogCreationClient);
            
            blogCreationClient.setMedia(files);
            
         
            
            
            Map<String, Object> postBlog = externalBlogService.postBlog(blogCreationClient);
            
            
            return postBlog;
        } catch (TeamNotFoundException | DepartmentNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new IOException("Error creating blog: " + e.getMessage());
        }
    }
}