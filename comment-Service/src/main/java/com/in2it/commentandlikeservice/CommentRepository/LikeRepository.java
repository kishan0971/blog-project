package com.in2it.commentandlikeservice.CommentRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LikeRepository extends JpaRepository<Like, Long>{

}
