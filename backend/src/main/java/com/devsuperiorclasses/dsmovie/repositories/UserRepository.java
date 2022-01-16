package com.devsuperiorclasses.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperiorclasses.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    // O framework já implementa automaticamente um método de busca por email
    User findByEmail(String email);
}
