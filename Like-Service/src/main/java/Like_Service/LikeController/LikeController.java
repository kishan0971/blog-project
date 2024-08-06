package Like_Service.LikeController;

import Like_Service.LikeEntity.Like;
import Like_Service.LikeService.LikeService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/in2it/like")
public class LikeController {

    @Autowired
    private LikeService likeService;

    //Put Api to Like and unlike a Post
    //require blogid and user id as parameters
    @PutMapping("/post/{blogid}/{userid}")
    private ResponseEntity<String> blogLike(@PathVariable("blogid") long blogid, @PathVariable("userid") long userid) {
        Like like = likeService.likepost(blogid, userid);
        if (like != null) {
            return ResponseEntity.status(HttpStatus.OK).body("user liked this blog ");
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("user unliked this blog ");
        }

    }
}

