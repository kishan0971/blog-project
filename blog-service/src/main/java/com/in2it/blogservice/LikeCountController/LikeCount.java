package com.in2it.blogservice.LikeCountController;

import com.in2it.blogservice.dto.BlogDto;
import com.in2it.blogservice.mapper.Converter;
import com.in2it.blogservice.repository.BlogRepository;
import com.in2it.blogservice.service.impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/in2it-blog")
public class LikeCount {

    @Autowired
    private BlogServiceImpl blogService;



    @Autowired
    private Converter objectMapper;

    @Autowired
    private BlogRepository repository;


    //*put api to unlike a blog and decrement the like count by -1
    @PutMapping("/unlikeblog/{blogid}")
    public ResponseEntity<String> unlikeBlog(@PathVariable("blogid") Long blogid) {
        BlogDto blog = blogService.getBlogById(blogid);
        if (blog != null) {
            blog.setLikeCount(blog.getLikeCount() - 1);
            blogService.saveBlog(blog);
            return ResponseEntity.ok().body("user unliked the blog");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }



    @PutMapping("/likeblog/{blogid}")
    public ResponseEntity<String> likeBlog(@PathVariable("blogid") Long blogid) {
        BlogDto blog = blogService.getBlogById(blogid);
        if (blog != null) {
            blog.setLikeCount(blog.getLikeCount() + 1);
            blogService.saveBlog(blog);
            return ResponseEntity.ok().body("user liked the blog");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
