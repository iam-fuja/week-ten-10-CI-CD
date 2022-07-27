package com.example.fashion_blog.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Comments {

    @Id
    @SequenceGenerator(name ="comments_sequence",
            sequenceName = "comments_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "comments_sequence")
    private Long id;



    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Blogger blogger;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Post post;

    private String feedback;
}
