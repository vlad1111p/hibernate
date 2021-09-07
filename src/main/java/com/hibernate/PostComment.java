package com.hibernate;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class PostComment {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="review")
    private String review;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public PostComment(String review, Post post) {
        this.review = review;
        this.post = post;
    }

    public PostComment() {
    }
}