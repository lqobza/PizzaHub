package com.example.PizzaHub.services;


import com.example.PizzaHub.entities.Feltet;
import com.example.PizzaHub.entities.Pizza;
import com.example.PizzaHub.repository.FeltetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeltetService {

    @Autowired
    FeltetRepository feltetRepository;

    public List<Feltet> getAll() { return feltetRepository.findAll(); }

    public ResponseEntity<Feltet> getFeltet(Long id) {
        Optional<Feltet> optionalFeltet = feltetRepository.findById(id);
        if(optionalFeltet.isPresent()) {
            return ResponseEntity.ok(optionalFeltet.get());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Iterable<Pizza>> getPizzak(Long id) {
        Optional<Feltet> optionalFeltet = feltetRepository.findById(id);
        if(optionalFeltet.isPresent()) {
            return ResponseEntity.ok(optionalFeltet.get().getPizzak());
        }
        return ResponseEntity.notFound().build();
    }

}
