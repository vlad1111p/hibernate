package com.hibernate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nume")
    private String nume;

    public User(String nume) {
        this.nume = nume;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "nume='" + nume + '\'' +
                '}';
    }
}
