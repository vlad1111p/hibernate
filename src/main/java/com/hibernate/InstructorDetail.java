package com.hibernate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Table(name ="instructor_detail")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", length = 30)
    private String description;

    public InstructorDetail(String detail){
        this.description = detail;
    }

}