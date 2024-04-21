package com.Mohit.demo.Entities;

import jakarta.persistence.*;


@Entity
@Table(name = "Employee", catalog = "test1")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Course")
    private String course;
    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(){
        this.name=name;

    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public UserEntity(int id, String name, String course){
        this.id=id;
        this.name=name;
        this.course=course;

    }
    public UserEntity(){

    }

    public String toString() {
        return "Tutorial [id=" + id + ", Name=" + name + ", Course=" + course + "]";
    }



}