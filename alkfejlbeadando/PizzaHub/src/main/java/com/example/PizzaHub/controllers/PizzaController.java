package com.example.PizzaHub.controllers;

import com.example.PizzaHub.entities.Alap;
import com.example.PizzaHub.entities.Feltet;
import com.example.PizzaHub.entities.Pizza;
import com.example.PizzaHub.entities.Teszta;
import com.example.PizzaHub.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/pizzak")
@RestController
public class PizzaController extends BaseController<Pizza, PizzaService> {

    @Autowired
    private PizzaService pizzaService;

//    @RequestMapping(method = RequestMethod.GET)
//    public List<Pizza> getAll() {
//        return pizzaService.getAll();
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public ResponseEntity<Pizza> getPizza(@PathVariable Long id) { return pizzaService.getPizza(id); }

    @RequestMapping(value = "/{id}/feltetek", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Feltet>> getFeltetek(@PathVariable Long id) {
        return pizzaService.getFeltetek(id);
    }

    @RequestMapping(value = "/{id}/teszta", method = RequestMethod.GET)
    public ResponseEntity<Teszta> getTeszta(@PathVariable Long id) {
        return pizzaService.getTeszta(id);
    }

    @RequestMapping(value = "/{id}/alap", method = RequestMethod.GET)
    public ResponseEntity<Alap> getAlap(@PathVariable Long id) {
        return pizzaService.getAlap(id);
    }



}
