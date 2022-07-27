package com.example.fashion_blog.service;

import com.example.fashion_blog.DTO.LikesDTO;
import com.example.fashion_blog.enums.Reaction;
import com.example.fashion_blog.model.Blogger;
import com.example.fashion_blog.model.Likes;
import com.example.fashion_blog.model.Post;
import com.example.fashion_blog.repository.BloggerRepository;
import com.example.fashion_blog.repository.LikesRepository;
import com.example.fashion_blog.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LikesService {
    private final LikesRepository likesRepository;
    private final BloggerRepository bloggerRepository;
    private  final PostRepository postRepository;

    public LikesService(LikesRepository likesRepository, BloggerRepository bloggerRepository, PostRepository postRepository) {
        this.likesRepository = likesRepository;
        this.bloggerRepository = bloggerRepository;
        this.postRepository = postRepository;
    }

    public List<Likes> getLikes() {
        return likesRepository.findAll();
    }

    public void addNewLikes(LikesDTO likesDto) {
        Blogger blogger = bloggerRepository.findById(likesDto.getBloggerId()).get();
        Post post = postRepository.findPostById(likesDto.getPostId()).get();
        Reaction reaction = likesDto.getReaction();
        Likes like = new Likes();
        like.setBlogger(blogger);
        like.setPost(post);
        like.setReaction(likesDto.getReaction());
//        Optional<Likes> likesOptional = likesRepository.findLikesById(likes.getId());
//        if (likesOptional.isPresent()) {
//            throw new IllegalStateException("post exists");
//        }
        likesRepository.save(like);
        System.out.println(like);
    }


    public void deleteLikes(Long id) {
        boolean liked = likesRepository.existsById(id);
        if (!liked) {
            throw new IllegalStateException("likes with ID " + id + "does not exist");
        }
        likesRepository.deleteById(id);
    }
}