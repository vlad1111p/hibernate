package com.hibernate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "first_name", length = 45)
    private String first_name;
    @Column(name = "last_name", length = 45)
    private String last_name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "phone_number", length = 45)
    private int phone_number;

    public Customers(String first_name, String last_name, Gender gender, int phone_number) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.phone_number = phone_number;
    }
}
