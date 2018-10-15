package com.example.PizzaHub.services;

import com.example.PizzaHub.entities.Pizza;
import com.example.PizzaHub.entities.Teszta;
import com.example.PizzaHub.repositories.TesztaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class TesztaService extends BaseService<Teszta,TesztaRepository> {

    public ResponseEntity<Iterable<Pizza>> getPizzak(Long id) {
        Optional<Teszta> optionalTeszta = rRepository.findById(id);
        if(optionalTeszta.isPresent()) {
            return ResponseEntity.ok(optionalTeszta.get().getPizzak());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Teszta> postTeszta(Map<String,Object> map) {
        try {
            if(!rRepository.findByNev(map.get("nev").toString()).isPresent()) {
                Teszta teszta = new Teszta(map.get("nev").toString(), Integer.parseInt((String) map.get("ar")));
                return ResponseEntity.ok(rRepository.save(teszta));
            }
        } catch (Exception e) {
            System.out.println("Hiba van a mátrixban! ");
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.IM_USED).build();
    }
}
