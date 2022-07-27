package com.example.fashion_blog.model;

import com.example.fashion_blog.enums.Reaction;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

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
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Blogger blogger;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Post post;
    private Reaction reaction;
}


