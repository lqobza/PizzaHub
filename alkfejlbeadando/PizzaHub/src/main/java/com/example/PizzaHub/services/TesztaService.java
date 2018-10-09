package com.example.PizzaHub.services;

import com.example.PizzaHub.entities.Pizza;
import com.example.PizzaHub.entities.Teszta;
import com.example.PizzaHub.repositories.TesztaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TesztaService extends BaseService<Teszta,TesztaRepository> {

    public ResponseEntity<Iterable<Pizza>> getPizzak(Long id) {
        Optional<Teszta> optionalTeszta = rRepository.findById(id);
        if(optionalTeszta.isPresent()) {
            return ResponseEntity.ok(optionalTeszta.get().getPizzak());
        }
        return ResponseEntity.notFound().build();
    }
}
