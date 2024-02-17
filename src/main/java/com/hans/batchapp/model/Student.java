package com.hans.batchapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;

    private String lastName;

    private Integer age;
}
