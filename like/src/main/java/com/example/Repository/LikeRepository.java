package com.example.Repository;

import com.example.Entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
@Query("from Like where blogid=:blogid and userid=:userid")
    Like findByBlogidUserid(@Param("blogid")long blogid, @Param("userid")long userid);
}
