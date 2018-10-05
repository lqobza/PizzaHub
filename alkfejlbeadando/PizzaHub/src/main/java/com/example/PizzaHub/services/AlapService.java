package com.example.PizzaHub.services;

import com.example.PizzaHub.entities.Alap;
import com.example.PizzaHub.entities.Pizza;
import com.example.PizzaHub.repositories.AlapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlapService extends BaseService<Alap, AlapRepository> {


    public ResponseEntity<Iterable<Pizza>> getPizzak(Long id) {
        Optional<Alap> optionalAlap =  rRepository.findById(id);
        if(optionalAlap.isPresent()) {
            return ResponseEntity.ok(optionalAlap.get().getPizzak());
        }
        return ResponseEntity.notFound().build();
    }

}
