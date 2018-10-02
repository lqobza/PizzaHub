package com.example.PizzaHub.repository;

import com.example.PizzaHub.entities.BaseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BaseRepository<T extends BaseEntity> extends CrudRepository<T , Long> {
    List<T> findAll();
}
