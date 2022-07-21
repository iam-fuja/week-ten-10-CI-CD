package com.example.fashion_blog.repository;

import com.example.fashion_blog.model.Blogger;
import com.example.fashion_blog.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {

    Optional<Likes> findLikesById(Long likesId);
}
