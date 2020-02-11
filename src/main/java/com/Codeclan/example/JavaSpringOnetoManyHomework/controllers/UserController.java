package com.Codeclan.example.JavaSpringOnetoManyHomework.controllers;


import com.Codeclan.example.JavaSpringOnetoManyHomework.models.User;
import com.Codeclan.example.JavaSpringOnetoManyHomework.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

//    INDEX
    @GetMapping(value = "/users")
    public ResponseEntity<List>getAllUsers(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

//    SHOW
    @GetMapping(value = "/users/{id}")
    public Optional<User> getUser(@PathVariable Long id){
        return userRepository.findById(id);
    }

//  SAVE
    @PostMapping(value = "/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}