package com.example.PizzaHub.repositories;

import com.example.PizzaHub.entities.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {
    Optional<User> findByUserName(String username);
    Optional<User> findByEmailAddress(String emailaddress);
}
