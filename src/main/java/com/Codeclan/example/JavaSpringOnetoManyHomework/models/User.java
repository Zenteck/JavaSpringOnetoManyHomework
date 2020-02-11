package com.Codeclan.example.JavaSpringOnetoManyHomework.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")

public class User {

    @Column(name = "userName")
    private String userName;

    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private List<Folder> folders;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public User(String userName) {
        this.userName = userName;
        this.folders = new ArrayList<>();
    }

    public User(){
    }

    public String getName() {
        return userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public Long getId() {
        return id;
    }


}
