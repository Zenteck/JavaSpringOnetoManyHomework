package com.Codeclan.example.JavaSpringOnetoManyHomework.repositories;


import com.Codeclan.example.JavaSpringOnetoManyHomework.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
}