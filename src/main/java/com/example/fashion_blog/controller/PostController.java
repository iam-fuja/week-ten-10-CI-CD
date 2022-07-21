package com.example.fashion_blog.controller;

import com.example.fashion_blog.model.Blogger;
import com.example.fashion_blog.model.Post;
import com.example.fashion_blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping
    public List<Post> getPosts(){
        return postService.getPosts();
    }

    @PostMapping
    public void createNewPost(@RequestBody Post post){
        postService.addNewPost(post);
    }

    @DeleteMapping(path="{postId}")
    public void deletePost(@PathVariable("postId") Long postId){
        postService.deletePost(postId);
    }

}
