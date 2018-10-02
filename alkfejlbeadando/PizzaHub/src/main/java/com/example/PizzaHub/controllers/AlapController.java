package com.example.PizzaHub.controllers;

import com.example.PizzaHub.entities.Alap;
import com.example.PizzaHub.entities.Pizza;
import com.example.PizzaHub.services.AlapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/alapok")
@RestController
public class AlapController extends BaseController<Alap,AlapService> {

    @Autowired
    private AlapService alapService;

//    @RequestMapping(method = RequestMethod.GET)
//    public List<Alap> getAll() { return alapService.getAll(); }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public ResponseEntity<Alap> getAlap(@PathVariable Long id) { return alapService.getAlap(id); }

    @RequestMapping(value = "/{id}/pizzak", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Pizza>> getPizzak(@PathVariable Long id) { return alapService.getPizzak(id); }


}
