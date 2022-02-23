package com.ridvan.app.sample.Models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;


@Entity
@Table(name="persondb")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//for auto-increment
    private long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private int age;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
