package com.exe1;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;



@Data
@AllArgsConstructor

public class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String phoneNumber;
    private String email;
    private int salary;
    private int departmentId;
    private int managerId;

    public int getId() {
        return employeeId;
    }

    public void setId(int id) {
        this.employeeId = id;
    }

    public Employee() {

    }
}
