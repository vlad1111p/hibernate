package com.hibernate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "instructor", indexes = {
        @Index(name = "instructor_detail_id", columnList = "instructor_detail_id")
})
@Entity
@Getter
@Setter
@RequiredArgsConstructor

public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "email", length = 30)
    private String email;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetail;

    public Instructor(String name, String email, InstructorDetail instructorDetail) {
        this.name = name;
        this.email = email;
        this.instructorDetail = instructorDetail;
    }
}