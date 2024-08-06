package Like_Service.LikeService;

import Like_Service.LikeEntity.Like;

public interface LikeService {
    Like likepost(long blogid, long userid);
}
