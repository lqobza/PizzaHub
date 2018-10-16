package com.example.PizzaHub.repositories;

import com.example.PizzaHub.entities.Feltet;
import com.example.PizzaHub.entities.Pizza;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PizzaRepository extends BaseRepository<Pizza> {
    Optional<Pizza> findByNev(String nev);
    Optional<Pizza> findByFeltetek(List<Feltet> feltetek);
}
