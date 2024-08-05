package com.example.Service;

import com.example.Entity.Like;

public interface LikeService {
    Like likepost(long blogid, long userid);

    //Long getLikeCountByBlogId(long blogid);
}
