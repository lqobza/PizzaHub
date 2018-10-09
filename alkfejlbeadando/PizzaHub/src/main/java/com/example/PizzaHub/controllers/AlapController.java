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

    @RequestMapping(value = "/{id}/pizzak", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Pizza>> getPizzak(@PathVariable Long id) { return rService.getPizzak(id); }

}
