package com.example.fashion_blog.service;

import com.example.fashion_blog.model.Post;
import com.example.fashion_blog.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;


    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPosts(){
        return postRepository.findAll();
    }

    public void addNewPost(Post post) {
        Optional<Post> postOptional = postRepository.findPostById(post.getId());
        if (postOptional.isPresent()){
            throw new IllegalStateException("post exists");
        }
        postRepository.save(post);
        System.out.println(post);
    }


    public void deletePost(Long id) {
        boolean posted = postRepository.existsById(id);
        if (!posted){
            throw new IllegalStateException("post with ID " + id + "does not exist");
        }
        postRepository.deleteById(id);
    }

}
