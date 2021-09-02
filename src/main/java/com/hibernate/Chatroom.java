package com.hibernate;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Chatroom {
    @Id
    @Column(name = "chatroom_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer chatroom_id;

    @Column(name = "recipient")
    private String recipient;

    @Column(name = "sender")
    private String sender;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy="chatroom")
    private Set<ChatMessage> messages;

    public Chatroom(String recipient, String sender, String title, Set<ChatMessage> messages) {
        this.recipient = recipient;
        this.sender = sender;
        this.title = title;
        this.messages = messages;
    }

    public Chatroom() {

    }
}