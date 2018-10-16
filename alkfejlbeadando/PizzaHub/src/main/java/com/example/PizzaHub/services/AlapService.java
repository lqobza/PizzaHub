package com.example.PizzaHub.services;

import com.example.PizzaHub.entities.Alap;
import com.example.PizzaHub.entities.Pizza;
import com.example.PizzaHub.repositories.AlapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AlapService extends BaseService<Alap, AlapRepository> {


    public ResponseEntity<Iterable<Pizza>> getPizzak(Long id) {
        Optional<Alap> optionalAlap =  rRepository.findById(id);
        if(optionalAlap.isPresent()) {
            return ResponseEntity.ok(optionalAlap.get().getPizzak());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Alap> postAlap(Map<String,Object> map) {
        try {
            if (!rRepository.findByNev(map.get("nev").toString()).isPresent()) {
                Alap alap = new Alap();
                alap.setAr(Integer.parseInt(map.get("ar").toString()));
                alap.setNev(map.get("nev").toString());
                return ResponseEntity.ok(rRepository.save(alap));
            }
        } catch (Exception e) {
            System.out.println("Hiba van a mátrixban! ");
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.IM_USED).build();
    }

}
