package com.example.PizzaHub.repository;

import com.example.PizzaHub.entities.Alap;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlapRepository extends CrudRepository<Alap, Long> {
    List<Alap> findAll();
}
