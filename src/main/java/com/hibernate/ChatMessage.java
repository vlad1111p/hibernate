package com.hibernate;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="chat_message")
public class ChatMessage {
    @Id
    @Column(name = "chat_message_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    @Column(name = "content")
    private String content;

    @Column(name = "sender")
    private String sender;

    @Column(name = "type")
    private Integer type;


    @ManyToOne
    @JoinColumn(name="chat_message_id", nullable=false ,insertable = false,updatable = false)
    private Chatroom chatroom;

    public ChatMessage(String content, String sender, Integer type, Chatroom chatroom) {
        this.content = content;
        this.sender = sender;
        this.type = type;
        this.chatroom = chatroom;
    }

    public ChatMessage() {

    }
}