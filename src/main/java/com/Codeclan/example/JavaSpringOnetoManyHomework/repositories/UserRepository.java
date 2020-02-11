package com.Codeclan.example.JavaSpringOnetoManyHomework.repositories;


import com.Codeclan.example.JavaSpringOnetoManyHomework.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
