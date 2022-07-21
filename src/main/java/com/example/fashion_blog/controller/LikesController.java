package com.example.fashion_blog.controller;

import com.example.fashion_blog.model.Blogger;
import com.example.fashion_blog.model.Likes;
import com.example.fashion_blog.service.BloggerService;
import com.example.fashion_blog.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/likes")
public class LikesController {

    private final LikesService likesService;

    @Autowired
    public LikesController(LikesService likesService) {
        this.likesService = likesService;
    }

    @GetMapping
    public List<Likes> getLikes() {
        return likesService.getLikes();
    }

    @PostMapping
    public void createNewLikes(@RequestBody Likes likes) {
        likesService.addNewLikes(likes);
    }

    @DeleteMapping(path = "{likesId}")
    public void deleteLikes(@PathVariable("likesId") Long likesId) {
        likesService.deleteLikes(likesId);
    }

}