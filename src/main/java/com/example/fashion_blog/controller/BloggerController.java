package com.example.fashion_blog.controller;

import com.example.fashion_blog.model.Blogger;
import com.example.fashion_blog.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/blogger")
public class BloggerController {
    private final BloggerService bloggerService;

    @Autowired
    public BloggerController(BloggerService bloggerService) {
        this.bloggerService = bloggerService;
    }


    @GetMapping
    public List<Blogger> getBloggers(){
        return bloggerService.getBloggers();
    }

    @PostMapping
    public void createNewBlogger(@RequestBody Blogger blogger){
        bloggerService.addNewBlogger(blogger);
    }

    @DeleteMapping(path="{bloggerId}")
    public void deleteBlogger(@PathVariable ("bloggerId") Long bloggerId){
        bloggerService.deleteBlogger(bloggerId);
    }

    @PutMapping(path = "{bloggerId}")
    public void updateBlogger(@PathVariable (value = "bloggerId") Long bloggerId,
                              @RequestParam(required = false)String fullName,
                              @RequestParam(required = false) String email)  {
        bloggerService.updateBlogger(bloggerId, fullName, email);

    }
}
