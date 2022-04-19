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


    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="recipient",referencedColumnName="user_id")
    private User recipient;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "sender", referencedColumnName = "user_id")
    private User sender;

    @Column(name = "type")
    private Integer type;

    @ManyToOne
    @JoinColumn(name="chat_message_id", nullable=false ,insertable = false,updatable = false)
    private Chatroom chatroom;

    public ChatMessage(String content, User sender, User recipient,Integer type, Chatroom chatroom) {
        this.content = content;
        this.sender = sender;
        this.type = type;
        this.chatroom = chatroom;
        this.recipient=recipient;
    }

    public ChatMessage() {

    }
}