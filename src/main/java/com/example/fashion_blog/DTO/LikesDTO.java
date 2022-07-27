package com.example.fashion_blog.DTO;

import com.example.fashion_blog.enums.Reaction;
import lombok.Data;

@Data
public class LikesDTO {
    private Long bloggerId;
    private Long postId;
    private Reaction reaction;
}

