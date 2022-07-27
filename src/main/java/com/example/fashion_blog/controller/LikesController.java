package com.example.fashion_blog.controller;

import com.example.fashion_blog.DTO.LikesDTO;
import com.example.fashion_blog.model.Likes;
import com.example.fashion_blog.repository.BloggerRepository;
import com.example.fashion_blog.repository.LikesRepository;
import com.example.fashion_blog.repository.PostRepository;
import com.example.fashion_blog.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/likes")
public class LikesController {

    private final LikesRepository likesRepository;
    private final BloggerRepository bloggerRepository;
    private  final PostRepository postRepository;

    @Autowired
    public LikesController(LikesService likesService, LikesRepository likesRepository, BloggerRepository bloggerRepository, PostRepository postRepository) {
        this.likesRepository = likesRepository;
        this.bloggerRepository = bloggerRepository;
        this.postRepository = postRepository;

    }

    @GetMapping
    public List<Likes> getLikes() {
        LikesService likesService1 = new LikesService(likesRepository,bloggerRepository,postRepository);
        return likesService1.getLikes();
    }

    @PostMapping
    public void createNewLikes(@RequestBody LikesDTO likesDto) {
        LikesService likesService1 = new LikesService(likesRepository,bloggerRepository,postRepository);
        likesService1.addNewLikes(likesDto);
    }

    @DeleteMapping(path = "{likesId}")
    public void deleteLikes(@PathVariable("likesId") Long likesId) {
        LikesService likesService1 = new LikesService(likesRepository,bloggerRepository,postRepository);
        likesService1.deleteLikes(likesId);
    }

}