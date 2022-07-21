package com.example.fashion_blog.service;

import com.example.fashion_blog.model.Comments;
import com.example.fashion_blog.model.Post;
import com.example.fashion_blog.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;

    @Autowired
    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }


    public List<Comments> getComments(){
        return commentsRepository.findAll();
    }

    public void addNewPost(Comments comments) {
        Optional<Comments> commentsOptional = commentsRepository.findCommentsById(comments.getCommentsId());
        if (commentsOptional.isPresent()){
            throw new IllegalStateException("comments exists");
        }
        commentsRepository.save(comments);
        System.out.println(comments);
    }


    public void deletePost(Long commentsId) {
        boolean commented = commentsRepository.existsById(commentsId);
        if (!commented){
            throw new IllegalStateException("comments with ID " + commentsId + "does not exist");
        }
        commentsRepository.deleteById(commentsId);
    }

}
