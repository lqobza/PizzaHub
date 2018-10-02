package com.example.PizzaHub.controllers;

import com.example.PizzaHub.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public abstract class BaseController<T, R extends BaseService> {

    @Autowired
    protected R rService;

    @RequestMapping(method = RequestMethod.GET)
    public List<T> getAll() { return rService.getAll(); }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<T> getT(@PathVariable Long id) { return rService.getT(id); }

}
