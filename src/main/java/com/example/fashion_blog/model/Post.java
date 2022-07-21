package com.example.fashion_blog.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Post {
    @Id
    @SequenceGenerator(name ="post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "post_sequence")
    private Long postId;
    private String productName;
    private String desc;
    private String article;
    private String image;
    private Float price;


    public Post() {
    }

    public Post(Long postId, String productName, String desc, String article, String image, Float price) {
        this.postId = postId;
        this.productName = productName;
        this.desc = desc;
        this.article = article;
        this.image = image;
        this.price = price;
    }

    public Post(String productName, String desc, String article, String image, Float price) {
        this.productName = productName;
        this.desc = desc;
        this.article = article;
        this.image = image;
        this.price = price;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", productName='" + productName + '\'' +
                ", desc='" + desc + '\'' +
                ", article='" + article + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                '}';
    }
}
