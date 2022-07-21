package com.example.fashion_blog.model;

import com.example.fashion_blog.enums.Reaction;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Likes {
    @Id
    @SequenceGenerator(name ="likes_sequence",
            sequenceName = "likes_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "likes_sequence")
    private Long likesId;
    private Blogger blogger;
    private Post post;
    private Reaction reaction;
}
