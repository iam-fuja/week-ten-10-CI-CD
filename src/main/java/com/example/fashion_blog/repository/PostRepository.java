package com.example.fashion_blog.repository;

import com.example.fashion_blog.model.Blogger;
import com.example.fashion_blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.postId = ?1")
    Optional<Post> findPostById(Long postId);

}
