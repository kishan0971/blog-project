package com.example.Service;

import com.example.Entity.Like;
import com.example.Repository.LikeRepository;
import com.example.feign.FeignInterface;
import com.in2it.blogservice.dto.BlogDto;
import com.in2it.blogservice.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private FeignInterface feign;


    @Override
    public Like likepost(long blogid, long userid) {
        ResponseEntity<BlogDto> blog = feign.getBlog(blogid);
        //User user = feign.getbyUserId(userid);
        // boolean  user = userid;
        if (blog.getBody() == null) {
            throw new RuntimeException("blog does not exist");
        }
//        if(user==null){
//            throw new RuntimeException("user does not exist");
//        }
        Like existinglike = likeRepository.findByBlogidUserid(blogid, userid);
        if (existinglike!=null) {
            likeRepository.delete(existinglike);
            blog.getBody().setLikeCount(blog.getBody().getLikeCount() - 1);
            feign.saveBlog(blog.getBody());


        } else {
            Like like = new Like();
            like.setBlogid(blogid);
            like.setUserid(userid);
            likeRepository.save(like);
            blog.getBody().setLikeCount(blog.getBody().getLikeCount() +1);
            feign.saveBlog(blog.getBody());
            return like;
        }


//    @Override
//    public Long getLikeCountByBlogId(long blogid) {
//       long count = likeRepository.CountByBlogId(blogid);
//return count;
//    }
        return existinglike;
    }

}
