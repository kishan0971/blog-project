package Like_Service.LikeController;

import Like_Service.FeignInterface.UserClient;
import Like_Service.LikeEntity.Like;
import Like_Service.LikeRepository.LikeRepository;
import Like_Service.LikeService.LikeService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/in2it/like")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UserClient userClient;

    //Put Api to Like and unlike a Post
    //require blogid and user id as parameters
    @PutMapping("/post/{blogid}/")
    private ResponseEntity<String> blogLike(@PathVariable("blogid") long blogid, @PathVariable("userid") long userid) {
        Like like = likeService.likepost(blogid, userid);
        if (like != null) {
            return ResponseEntity.status(HttpStatus.OK).body("user liked this blog ");
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("user unliked this blog ");
        }

    }




    //api to get

    @GetMapping("getusernames/wholikedblog")
    public ResponseEntity<List<String>> getUsernamesWhoLikedBlog(@PathVariable("blogid") long blogid) {
        //it will provide the list of likes who liked blog with the provided blogid
        List<Like> likes = likeRepository.FindByBlogId(blogid);
        //it will send the list of userid to userclient to fetch the usernames
        List<Long> userids= likes.stream().map(Like::getUserid).collect(Collectors.toList());
       return userClient.getUsernameByIds(userids);


}
}

