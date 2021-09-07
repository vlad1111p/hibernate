package com.hibernate;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="post")
public class Post {
    @Setter(AccessLevel.NONE)
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(name = "title")
    private String title;




    @OneToMany(mappedBy="post", cascade=CascadeType.ALL,orphanRemoval = true)
    private List<PostComment> postcomments = new ArrayList<PostComment>();

    public Post(String title) {
        this.title = title;
    }

    public void addComment(PostComment comment) {
        postcomments.add(comment);
        comment.setPost(this);

    }

    public Post() {

    }
}