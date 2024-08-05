package com.example.feign;

import com.in2it.blogservice.dto.BlogDto;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="blog-service" , url="http://localhost:8080/in2it-blog")
public interface FeignInterface {

    @GetMapping("/get-blog-by-id/{blogId}")
    public ResponseEntity<BlogDto> getBlog(@PathVariable(value = "blogId") Long id) ;

    @PostMapping("/posts")
    public ResponseEntity<BlogDto> saveBlog(@RequestBody BlogDto blogDto);

}
