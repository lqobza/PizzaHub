package com.example.PizzaHub.services;

import com.example.PizzaHub.entities.Alap;
import com.example.PizzaHub.entities.Feltet;
import com.example.PizzaHub.entities.Pizza;
import com.example.PizzaHub.entities.Teszta;
import com.example.PizzaHub.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PizzaService extends BaseService<Pizza, PizzaRepository> {

    public ResponseEntity<Iterable<Feltet>> getFeltetek(Long id) {
        Optional<Pizza> optionalPizza = rRepository.findById(id);
        if (optionalPizza.isPresent()) {
            return ResponseEntity.ok(optionalPizza.get().getFeltetek());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Teszta> getTeszta(Long id) {
        Optional<Pizza> optionalPizza = rRepository.findById(id);
        if(optionalPizza.isPresent()) {
            return ResponseEntity.ok(optionalPizza.get().getTeszta());
        }
        return  ResponseEntity.notFound().build();
    }

    public ResponseEntity<Alap> getAlap(Long id) {
        Optional<Pizza> optionalPizza = rRepository.findById(id);
        if(optionalPizza.isPresent()) {
            return ResponseEntity.ok(optionalPizza.get().getAlap());
        }
        return  ResponseEntity.notFound().build();
    }


}
