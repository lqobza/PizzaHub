package com.example.PizzaHub.controllers;

import com.example.PizzaHub.entities.Feltet;
import com.example.PizzaHub.entities.Pizza;
import com.example.PizzaHub.services.FeltetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/feltetek")
@RestController
public class FeltetController {

    @Autowired
    private FeltetService feltetService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Feltet> getAll() { return feltetService.getAll(); }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Feltet> getFeltet(@PathVariable Long id) { return feltetService.getFeltet(id); }

    @RequestMapping(value = "/{id}/pizzak", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Pizza>> getPizzak(@PathVariable Long id) {return feltetService.getPizzak(id); }

}