package com.example.fashion_blog.service;

import com.example.fashion_blog.repository.BloggerRepository;
import com.example.fashion_blog.model.Blogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BloggerService {


    private final BloggerRepository bloggerRepository;


    @Autowired
    public BloggerService(BloggerRepository bloggerRepository) {
        this.bloggerRepository = bloggerRepository;
    }

    public List<Blogger> getBloggers(){
        return bloggerRepository.findAll();
    }

    public void addNewBlogger(Blogger blogger) {
        Optional<Blogger> bloggerOptional = bloggerRepository.findBloggerByEmail(blogger.getEmail());
        if (bloggerOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        bloggerRepository.save(blogger);
        System.out.println(blogger);
    }


    public void deleteBlogger(Long bloggerId) {
    boolean exists = bloggerRepository.existsById(bloggerId);
    if (!exists){
        throw new IllegalStateException("blogger with ID " + bloggerId + "does not exist");
    }
        bloggerRepository.deleteById(bloggerId);
    }

    @Transactional
    public void updateBlogger(Long bloggerId, String fullName, String email) {
        Blogger blogger = bloggerRepository.findById(bloggerId)
                .orElseThrow(() -> new IllegalStateException("blogger with ID " + bloggerId + "does not exist"));
        if (fullName != null &&
                fullName.length() > 0 &&
                Objects.equals(blogger.getFullName(), fullName)){
            blogger.setFullName(fullName);
        }

        if ( email != null &&
              email.length() > 0 &&
               Objects.equals(blogger.getEmail(), email)){
            Optional<Blogger> bloggerOptional = bloggerRepository.findBloggerByEmail(email);

        if (bloggerOptional.isPresent()){
            throw new IllegalStateException("email taken");
            }
        blogger.setEmail(email);
        Blogger blogger1 = new Blogger();
        blogger1.setFullName(blogger.getFullName());
        blogger1.setEmail(blogger.getEmail());
        blogger1.setPassword(blogger.getPassword());

        blogger.setEmail(blogger1.getEmail());
        blogger.setFullName(blogger1.getFullName());
        blogger.setPassword(blogger1.getPassword());
        bloggerRepository.save(blogger);
        }
        }
}