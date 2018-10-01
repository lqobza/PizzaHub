package com.example.PizzaHub.repository;

import com.example.PizzaHub.entities.Feltet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeltetRepository extends CrudRepository<Feltet, Long> {
    List<Feltet> findAll();
}
