package com.example.PizzaHub.repositories;

import com.example.PizzaHub.entities.Feltet;
import com.example.PizzaHub.entities.Pizza;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends BaseRepository<Pizza> {

    Optional<Pizza> findByFeltetek(List<Feltet> feltetek);
}
