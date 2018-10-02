package com.example.PizzaHub.controllers;

import com.example.PizzaHub.entities.BaseEntity;
import com.example.PizzaHub.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public abstract class BaseController<T extends BaseEntity> {

    @Autowired
    private BaseService<T> rService;

    @RequestMapping(method = RequestMethod.GET)
    public List<T> getAll() { return rService.getAll(); }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<T> getT(@PathVariable Long id) { return rService.getT(id); }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteT(@PathVariable Long id) { return rService.deleteT(id); }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<T> postT(@RequestBody T t) { return rService.postT(t); }

}
