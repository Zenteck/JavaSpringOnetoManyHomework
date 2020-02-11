package com.Codeclan.example.JavaSpringOnetoManyHomework.controllers;


import com.Codeclan.example.JavaSpringOnetoManyHomework.models.Folder;
import com.Codeclan.example.JavaSpringOnetoManyHomework.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class FolderController {

    @Autowired
    private FolderRepository folderRepository;

//    INDEX
    @GetMapping(value = "/folders")
    public ResponseEntity<List> getAllFolders(){
        return new ResponseEntity<>(folderRepository.findAll(), HttpStatus.OK);
    }
//  SHOW
  @GetMapping(value = "/folders/{id}")
    public Optional<Folder> getFolder(@PathVariable Long id){
        return folderRepository.findById(id);
    }

//CREATE
    @PostMapping(value = "/folders")
    public ResponseEntity<Folder> createFolder(@RequestBody Folder folder){
        folderRepository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }
}
