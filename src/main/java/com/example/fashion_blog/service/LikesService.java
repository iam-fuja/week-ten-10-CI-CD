package com.example.fashion_blog.service;

import com.example.fashion_blog.model.Likes;
import com.example.fashion_blog.model.Post;
import com.example.fashion_blog.repository.LikesRepository;
import com.example.fashion_blog.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LikesService {
    private final LikesRepository likesRepository;

    public LikesService(LikesRepository likesRepository) {
        this.likesRepository = likesRepository;
    }

    public List<Likes> getLikes() {
        return likesRepository.findAll();
    }

    public void addNewLikes(Likes likes) {
        Optional<Likes> likesOptional = likesRepository.findLikesById(likes.getLikesId());
        if (likesOptional.isPresent()) {
            throw new IllegalStateException("post exists");
        }
        likesRepository.save(likes);
        System.out.println(likes);
    }


    public void deleteLikes(Long likesId) {
        boolean liked = likesRepository.existsById(likesId);
        if (!liked) {
            throw new IllegalStateException("likes with ID " + likesId + "does not exist");
        }
        likesRepository.deleteById(likesId);
    }
}