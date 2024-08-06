package Like_Service.LikeService;

import Like_Service.FeignInterface.FeignInterface;
import Like_Service.LikeEntity.Like;
import Like_Service.LikeRepository.LikeRepository;
import com.in2it.blogservice.dto.BlogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

        @Autowired
        private LikeRepository likeRepository;

        @Autowired
        private FeignInterface feign;

        @Override
        public Like likepost(long blogid, long userid) {
            ResponseEntity<BlogDto> response = feign.getBlogById(blogid);
            BlogDto blog = response.getBody();

            if (blog == null) {
                throw new RuntimeException("Blog does not exist");
            }

            Like existingLike = likeRepository.findByBlogidAndUserid(blogid, userid);
            if (existingLike != null) {
                likeRepository.delete(existingLike);
                feign.unlikeBlog(blogid);
            } else {
                Like like = new Like();
                like.setBlogid(blogid);
                like.setUserid(userid);
                likeRepository.save(like);
                feign.likeBlog(blogid);
                return like;
            }
            return null;
        }
    }




