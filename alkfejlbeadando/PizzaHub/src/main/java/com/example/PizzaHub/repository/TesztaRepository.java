package com.example.PizzaHub.repository;

import com.example.PizzaHub.entities.Teszta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TesztaRepository extends CrudRepository<Teszta, Long> {
    List<Teszta> findAll();
}
