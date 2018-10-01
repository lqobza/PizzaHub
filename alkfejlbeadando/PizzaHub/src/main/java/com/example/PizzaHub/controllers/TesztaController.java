package com.example.PizzaHub.controllers;

import com.example.PizzaHub.entities.Pizza;
import com.example.PizzaHub.entities.Teszta;
import com.example.PizzaHub.services.TesztaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/tesztak")
@RestController
public class TesztaController {

    @Autowired
    private TesztaService tesztaService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Teszta> getAll() { return tesztaService.getAll(); }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Teszta> getTeszta(@PathVariable Long id) { return tesztaService.getTeszta(id); }

    @RequestMapping(value = "/{id}/pizzak", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Pizza>> getPizzak(@PathVariable Long id) { return tesztaService.getPizzak(id); }
}
