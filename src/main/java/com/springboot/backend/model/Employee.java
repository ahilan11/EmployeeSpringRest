package com.springboot.backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="first_name", nullable = false)
    private String name;

    @Column(name="last_name", nullable = false)
    private String surname;

    @Column(name="email", nullable = false)
    private String email;
}
