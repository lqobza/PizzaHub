package com.example.PizzaHub.controllers;

import com.example.PizzaHub.entities.Alap;
import com.example.PizzaHub.entities.Feltet;
import com.example.PizzaHub.entities.Pizza;
import com.example.PizzaHub.entities.Teszta;
import com.example.PizzaHub.services.PizzaService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/pizzak")
@RestController
public class PizzaController extends BaseController<Pizza,PizzaService> {

    //GET HOZZAVALOK
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

    //POST HOZZAVALOK
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/{pizzaid}/feltetek/{feltetid}", method = RequestMethod.POST)
    public ResponseEntity<?> postFeltet(@PathVariable Long pizzaid, @PathVariable Long feltetid) {
        return rService.postFeltet(pizzaid,feltetid);
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/{pizzaid}/teszta/{tesztaid}", method = RequestMethod.POST)
    public ResponseEntity<?> postTeszta(@PathVariable Long pizzaid, @PathVariable Long tesztaid) {
        return rService.postTeszta(pizzaid, tesztaid);
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/{pizzaid}/alap/{alapid}", method = RequestMethod.POST)
    public ResponseEntity<?> postAlap(@PathVariable Long pizzaid, @PathVariable Long alapid) {
        return rService.postAlap(pizzaid, alapid);
    }

    //DELETE HOZZAVALOK
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/{pizzaid}/feltetek/{feltetid}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteFeltet(@PathVariable Long pizzaid,@PathVariable Long feltetid) {
        return rService.deleteFeltet(pizzaid,feltetid);
    }

    //POST PIZZA
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postPizza(@RequestBody Map<String,Object> pizza) { return rService.postPizza(pizza); }


}
