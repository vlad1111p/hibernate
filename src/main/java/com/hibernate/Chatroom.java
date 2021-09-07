package com.hibernate;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import com.hibernate.User;
@Entity
@Getter
@Setter
public class Chatroom {
    @Id
    @Column(name = "chatroom_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer chatroom_id;



    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy="chatroom", cascade=CascadeType.ALL,orphanRemoval = true)
    private Set<ChatMessage> messages;

    public Chatroom( String title, Set<ChatMessage> messages) {

        this.title = title;
        this.messages = messages;
    }

    public Chatroom() {

    }
}