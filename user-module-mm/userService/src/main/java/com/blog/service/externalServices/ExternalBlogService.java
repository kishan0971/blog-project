package com.blog.service.externalServices;

import com.blog.repository.DTO.BlogCreationFeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.Map;

@FeignClient(name = "blog-service", url = "http://localhost:8080")
public interface ExternalBlogService {

	@PostMapping(path = "/in2it-blog/posts", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	Map<String,Object> postBlog(@ModelAttribute  BlogCreationFeignClient blogCreationFeignClient);
}

