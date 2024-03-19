package com.example.calculator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.calculator.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String username);
}