package com.example.PizzaHub.services;

import com.example.PizzaHub.entities.BaseEntity;
import com.example.PizzaHub.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class BaseService<T extends BaseEntity, R extends BaseRepository> {

    @Autowired
    protected R rRepository;

    public List<T> getAll() {
        return rRepository.findAll();
    }

    public ResponseEntity<T> getT(Long id) {
        Optional<T> optionalT = rRepository.findById(id);
        if(optionalT.isPresent()) {
            return ResponseEntity.ok(optionalT.get());
        }
        return ResponseEntity.notFound().build();
    }

}
