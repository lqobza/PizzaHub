package com.example.PizzaHub.services;

import com.example.PizzaHub.entities.Alap;
import com.example.PizzaHub.entities.Pizza;
import com.example.PizzaHub.repository.AlapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Service
public class AlapService {

    @Autowired
    private AlapRepository alapRepository;

    public List<Alap> getAll() { return alapRepository.findAll(); }

    public ResponseEntity<Alap> getAlap(Long id) {
        Optional<Alap> optionalAlap =  alapRepository.findById(id);
        if(optionalAlap.isPresent()) {
            return ResponseEntity.ok(optionalAlap.get());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Iterable<Pizza>> getPizzak(Long id) {
        Optional<Alap> optionalAlap =  alapRepository.findById(id);
        if(optionalAlap.isPresent()) {
            return ResponseEntity.ok(optionalAlap.get().getPizzak());
        }
        return ResponseEntity.notFound().build();
    }

}
