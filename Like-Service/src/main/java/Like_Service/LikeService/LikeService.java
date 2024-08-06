package Like_Service.LikeService;

import Like_Service.LikeEntity.Like;

import java.util.List;

public interface LikeService {
    Like likepost(long blogid, long userid);

}
