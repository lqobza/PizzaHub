package com.example.PizzaHub.services;

import com.example.PizzaHub.entities.Alap;
import com.example.PizzaHub.entities.Feltet;
import com.example.PizzaHub.entities.Pizza;
import com.example.PizzaHub.entities.Teszta;
import com.example.PizzaHub.repositories.AlapRepository;
import com.example.PizzaHub.repositories.FeltetRepository;
import com.example.PizzaHub.repositories.PizzaRepository;
import com.example.PizzaHub.repositories.TesztaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PizzaService extends BaseService<Pizza, PizzaRepository> {

    public ResponseEntity<Iterable<Feltet>> getFeltetek(Long id) {
        Optional<Pizza> optionalPizza = rRepository.findById(id);
        if (optionalPizza.isPresent()) {
            return ResponseEntity.ok(optionalPizza.get().getFeltetek());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Teszta> getTeszta(Long id) {
        Optional<Pizza> optionalPizza = rRepository.findById(id);
        if(optionalPizza.isPresent()) {
            return ResponseEntity.ok(optionalPizza.get().getTeszta());
        }
        return  ResponseEntity.notFound().build();
    }

    public ResponseEntity<Alap> getAlap(Long id) {
        Optional<Pizza> optionalPizza = rRepository.findById(id);
        if(optionalPizza.isPresent()) {
            return ResponseEntity.ok(optionalPizza.get().getAlap());
        }
        return  ResponseEntity.notFound().build();
    }

    @Autowired
    private
    TesztaRepository tesztaRepository;
    @Autowired
    private
    AlapRepository alapRepository;
    @Autowired
    private
    FeltetRepository feltetRepository;

    public ResponseEntity<Pizza> postPizza(Map<String, Object> map) {
        try {
            if (!rRepository.findByNev(map.get("nev").toString()).isPresent() && !rRepository.findByFeltetek((List<Feltet>) map.get("feltetek")).isPresent()) {
                List<Long> feltetIdk = (List<Long>) map.get("feltetek");
                List<Feltet> feltetek = Collections.emptyList();
                for (Long id : feltetIdk) {
                    feltetek.add(feltetRepository.findById(id).get());
                }
                Pizza pizza = new Pizza(map.get("nev").toString(), Integer.parseInt(map.get("ar").toString()), tesztaRepository.findById((Long) map.get("teszta")).get(), alapRepository.findById((Long) map.get("alap")).get(), feltetek);
            }
        } catch(Exception e) {
            System.out.println("Hiba van a mátrixban!");
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.IM_USED).build();
    }


}
