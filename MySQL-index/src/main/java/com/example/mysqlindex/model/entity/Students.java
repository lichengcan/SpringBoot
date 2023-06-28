package com.example.mysqlindex.model.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author lichengcan
 */
@Entity
@Table(name = "Students")
@Data
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "tel")
    private String tel;

    @Column(name = "grade")
    private Integer grade;
}