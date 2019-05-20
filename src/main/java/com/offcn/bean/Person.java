package com.offcn.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name",nullable = true,length = 15)
    private String name;

    @Column(name = "age",nullable = true,length = 5)
    private int age;


}
