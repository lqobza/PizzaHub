package com.example.PizzaHub.repositories;

import com.example.PizzaHub.entities.User;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User> {
    Optional<User> findByUserName(String username);
    Optional<User> findByEmailAddress(String emailaddress);
}
