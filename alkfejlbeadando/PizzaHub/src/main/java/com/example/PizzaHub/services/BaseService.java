package com.example.PizzaHub.services;

import com.example.PizzaHub.entities.BaseEntity;
import com.example.PizzaHub.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class BaseService<T extends BaseEntity> {

    @Autowired
    private BaseRepository<T> rRepository;

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

    public ResponseEntity<Boolean> deleteT(Long id) {
        Optional<T> optionalT = rRepository.findById(id);
        if(optionalT.isPresent()) {
            rRepository.delete(optionalT.get());
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<T> postT(T t) {
        System.out.println(t);
        return ResponseEntity.ok(rRepository.save(t));
    }

}
