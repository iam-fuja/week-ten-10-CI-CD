package com.example.fashion_blog.repository;

import com.example.fashion_blog.model.Blogger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BloggerRepository extends JpaRepository<Blogger, Long> {

    @Query("SELECT b FROM Blogger b WHERE b.email = ?1")
    Optional<Blogger> findBloggerByEmail(String email);
}
