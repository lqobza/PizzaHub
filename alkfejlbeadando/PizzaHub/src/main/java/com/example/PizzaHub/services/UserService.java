package com.example.PizzaHub.services;

import com.example.PizzaHub.entities.Pizza;
import com.example.PizzaHub.entities.User;
import com.example.PizzaHub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService extends BaseService<User> {

    @Autowired
    private UserRepository userRepository;

//    public List<User> getAll() {return userRepository.findAll(); }
//
//    public ResponseEntity<User> getUser(Long id) {
//        Optional<User> optionalUser = userRepository.findById(id);
//        if(optionalUser.isPresent()) {
//            return ResponseEntity.ok(optionalUser.get());
//        }
//        return ResponseEntity.notFound().build();
//    }

    public ResponseEntity<Iterable<Pizza>> getPizzak(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get().getPizzak());
        }
        return ResponseEntity.notFound().build();
    }

}
