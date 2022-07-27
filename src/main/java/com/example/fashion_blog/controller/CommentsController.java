package com.example.fashion_blog.controller;

import com.example.fashion_blog.DTO.CommentsDTO;
import com.example.fashion_blog.model.Comments;
import com.example.fashion_blog.model.Post;
import com.example.fashion_blog.service.CommentsService;
import com.example.fashion_blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/comments")
public class CommentsController {

    private final CommentsService commentsService;

    @Autowired
    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }


    @GetMapping
    public List<Comments> getComments(){
        return commentsService.getComments();
    }

    @PostMapping
    public void createNewComments(@RequestBody CommentsDTO commentsDto){
        commentsService.createNewComments(commentsDto);
    }

    @DeleteMapping(path="{commentsId}")
    public void deleteComments(@PathVariable("commentsId") Long commentsId){
        commentsService.deleteComments(commentsId);
    }
}