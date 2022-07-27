package com.example.fashion_blog.DTO;


import lombok.Data;

@Data
public class CommentsDTO {

    private Long bloggerId;
    private Long postId;
    private String feedback;
}
