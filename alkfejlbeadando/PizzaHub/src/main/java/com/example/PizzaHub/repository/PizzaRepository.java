package com.example.PizzaHub.repository;

import com.example.PizzaHub.entities.Pizza;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PizzaRepository extends CrudRepository<Pizza, Long> {
    List<Pizza> findAll();
}
