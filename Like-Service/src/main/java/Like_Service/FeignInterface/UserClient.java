package Like_Service.LikeController;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="user-service" , url="http://localhost:8083/in2it/blog/like" )
public interface UserClient {


   // @GetMapping("/getuserbyid")
  //  public ResponseEntity<User> getUserById(@PathVariable("userid") long userid);



    @PostMapping("/getusernamesbyids")
    public List<String> getUsernameByIda(@RequestBody List<Long> userids);
}
