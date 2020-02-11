package com.Codeclan.example.JavaSpringOnetoManyHomework.controllers;



import com.Codeclan.example.JavaSpringOnetoManyHomework.models.File;
import com.Codeclan.example.JavaSpringOnetoManyHomework.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class FileController {

    @Autowired
    private FileRepository fileRepository;

//    INDEX
    @GetMapping(value = "/files")
    public ResponseEntity<List> getAllFiles(){
        return new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
    }
//  SHOW
    @GetMapping(value = "/files/{id}")
    public Optional<File> getFile(@PathVariable Long id){
        return fileRepository.findById(id);
    }

//CREATE
    @PostMapping(value = "/files")
    public ResponseEntity<File> createFile(@RequestBody File file){
        fileRepository.save(file);
        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }
}
