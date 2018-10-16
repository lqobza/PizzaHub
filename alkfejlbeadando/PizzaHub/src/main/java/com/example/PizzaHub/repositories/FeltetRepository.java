package com.example.PizzaHub.repositories;

import com.example.PizzaHub.entities.Feltet;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeltetRepository extends BaseRepository<Feltet> {
    Optional<Feltet> findByNev(String nev);
}
