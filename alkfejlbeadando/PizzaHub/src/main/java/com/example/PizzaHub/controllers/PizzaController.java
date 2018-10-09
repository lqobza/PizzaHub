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

@RequestMapping("/pizzak")
@RestController
public class PizzaController extends BaseController<Pizza,PizzaService> {

    @RequestMapping(value = "/{id}/feltetek", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Feltet>> getFeltetek(@PathVariable Long id) {
        return rService.getFeltetek(id);
    }

    @RequestMapping(value = "/{id}/teszta", method = RequestMethod.GET)
    public ResponseEntity<Teszta> getTeszta(@PathVariable Long id) {
        return rService.getTeszta(id);
    }

    @RequestMapping(value = "/{id}/alap", method = RequestMethod.GET)
    public ResponseEntity<Alap> getAlap(@PathVariable Long id) {
        return rService.getAlap(id);
    }


}
