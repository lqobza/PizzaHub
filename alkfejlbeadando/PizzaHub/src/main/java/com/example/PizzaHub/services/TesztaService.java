package com.example.PizzaHub.services;

import com.example.PizzaHub.entities.Pizza;
import com.example.PizzaHub.entities.Teszta;
import com.example.PizzaHub.repository.TesztaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TesztaService {

    @Autowired
    private TesztaRepository tesztaRepository;

    public List<Teszta> getAll() { return tesztaRepository.findAll(); }

    public ResponseEntity<Teszta> getTeszta(Long id) {
        Optional<Teszta> optionalTeszta = tesztaRepository.findById(id);
        if(optionalTeszta.isPresent()) {
            return ResponseEntity.ok(optionalTeszta.get());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Iterable<Pizza>> getPizzak(Long id) {
        Optional<Teszta> optionalTeszta = tesztaRepository.findById(id);
        if(optionalTeszta.isPresent()) {
            return ResponseEntity.ok(optionalTeszta.get().getPizzak());
        }
        return ResponseEntity.notFound().build();
    }
}
