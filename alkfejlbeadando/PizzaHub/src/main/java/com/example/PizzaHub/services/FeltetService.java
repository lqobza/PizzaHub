package com.example.PizzaHub.services;


import com.example.PizzaHub.entities.Feltet;
import com.example.PizzaHub.entities.Pizza;
import com.example.PizzaHub.repositories.FeltetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class FeltetService extends BaseService<Feltet, FeltetRepository> {

    public ResponseEntity<Iterable<Pizza>> getPizzak(Long id) {
        Optional<Feltet> optionalFeltet = rRepository.findById(id);
        if(optionalFeltet.isPresent()) {
            return ResponseEntity.ok(optionalFeltet.get().getPizzak());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Feltet> postFeltet(Map<String,Object> map) {
        try {
            if (!rRepository.findByNev(map.get("nev").toString()).isPresent()) {
                Feltet feltet = new Feltet();
                feltet.setNev(map.get("nev").toString());
                feltet.setAr(Integer.parseInt(map.get("ar").toString()));
                return ResponseEntity.ok(rRepository.save(feltet));
            }
        } catch (Exception e) {
            System.out.println("Hiba van a mátrixban! ");
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.IM_USED).build();
    }
}
