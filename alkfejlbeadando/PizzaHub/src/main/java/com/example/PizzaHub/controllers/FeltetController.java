package com.example.PizzaHub.controllers;

import com.example.PizzaHub.entities.Feltet;
import com.example.PizzaHub.entities.Pizza;
import com.example.PizzaHub.services.FeltetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/feltetek")
@RestController
public class FeltetController extends BaseController<Feltet,FeltetService> {

    @RequestMapping(value = "/{id}/pizzak", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Pizza>> getPizzak(@PathVariable Long id) {return rService.getPizzak(id); }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postFeltet(@RequestBody Map<String,Object> map) { return rService.postFeltet(map); }
}
