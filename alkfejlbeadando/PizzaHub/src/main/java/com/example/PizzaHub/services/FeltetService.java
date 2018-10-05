package com.example.PizzaHub.services;


import com.example.PizzaHub.entities.Feltet;
import com.example.PizzaHub.entities.Pizza;
import com.example.PizzaHub.repositories.FeltetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeltetService extends BaseService<Feltet, FeltetRepository> {

    public ResponseEntity<Iterable<Pizza>> getPizzak(Long id) {
        Optional<Feltet> optionalFeltet = rRepository.findById(id);
        if(optionalFeltet.isPresent()) {
            return ResponseEntity.ok(optionalFeltet.get().getPizzak());
        }
        return ResponseEntity.notFound().build();
    }

}
