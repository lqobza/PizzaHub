package com.example.PizzaHub.repositories;

import com.example.PizzaHub.entities.Alap;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlapRepository extends BaseRepository<Alap> {
    Optional<Alap> findByNev(String nev);
}
