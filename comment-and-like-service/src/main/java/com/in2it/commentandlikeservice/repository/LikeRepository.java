package com.in2it.commentandlikeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in2it.commentandlikeservice.model.Like;


@Repository
public interface LikeRepository extends JpaRepository<Like, Long>{

}
