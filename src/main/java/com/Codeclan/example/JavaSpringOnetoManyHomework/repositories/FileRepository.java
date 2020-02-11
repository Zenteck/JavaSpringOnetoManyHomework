package com.Codeclan.example.JavaSpringOnetoManyHomework.repositories;


import com.Codeclan.example.JavaSpringOnetoManyHomework.models.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
}
