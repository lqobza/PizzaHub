package com.example.PizzaHub.repositories;

import com.example.PizzaHub.entities.Teszta;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TesztaRepository extends BaseRepository<Teszta> {
    Optional<Teszta> findByNev(String nev);
}
