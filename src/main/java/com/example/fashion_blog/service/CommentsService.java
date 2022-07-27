package com.example.fashion_blog.service;

import com.example.fashion_blog.DTO.CommentsDTO;
import com.example.fashion_blog.model.Blogger;
import com.example.fashion_blog.model.Comments;
import com.example.fashion_blog.model.Post;
import com.example.fashion_blog.repository.BloggerRepository;
import com.example.fashion_blog.repository.CommentsRepository;
import com.example.fashion_blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;
    private final BloggerRepository bloggerRepository;
    private final PostRepository postRepository;

    @Autowired
    public CommentsService(CommentsRepository commentsRepository, BloggerRepository bloggerRepository, PostRepository postRepository) {
        this.commentsRepository = commentsRepository;
        this.bloggerRepository = bloggerRepository;
        this.postRepository = postRepository;
    }


    public List<Comments> getComments(){
        return commentsRepository.findAll();
    }

    public void createNewComments(CommentsDTO commentsDto) {
        Blogger blogger = bloggerRepository.findById(commentsDto.getBloggerId()).get();
        Post post = postRepository.findPostById(commentsDto.getPostId()).get();
        Comments comments = new Comments();
        comments.setPost(post);
        comments.setBlogger(blogger);
        comments.setFeedback(commentsDto.getFeedback());
//        Optional<Comments> commentsOptional = commentsRepository.findCommentsById(commentsDto.getId());
//        if (commentsOptional.isPresent()){
//            throw new IllegalStateException("comments exists");
//        }
        commentsRepository.save(comments);
        System.out.println(comments);
    }


    public void deleteComments(Long id) {
        boolean commented = commentsRepository.existsById(id);
        if (!commented){
            throw new IllegalStateException("comments with ID " + id + "does not exist");
        }
        commentsRepository.deleteById(id);
    }

}
