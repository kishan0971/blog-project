package Like_Service.FeignInterface;

import com.in2it.blogservice.dto.BlogDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="blog-service" , url="http://localhost:8080/in2it-blog/")
public interface FeignInterface {

    //get api to get blog by blog
    @GetMapping("/getByBlogId/{blogId}")
    public ResponseEntity<BlogDto> getBlogById(@PathVariable(value = "blogId") @Valid Long id) ;


    //post api to save blog
    @PostMapping("/posts")
    public ResponseEntity<BlogDto> saveBlog(@RequestBody BlogDto blogDto);


    @PutMapping("unlikeblog/{blogid}")
    public void unlikeBlog(@PathVariable("blogid") Long blogid);


    @PutMapping("likeblog/{blogid}")
    public void likeBlog(@PathVariable("blogid") Long blogid);
}
