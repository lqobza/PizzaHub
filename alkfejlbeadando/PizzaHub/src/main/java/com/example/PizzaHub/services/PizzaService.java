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

import java.util.*;

@Service
public class PizzaService extends BaseService<Pizza, PizzaRepository> {

    @Autowired
    private TesztaRepository tesztaRepository;
    @Autowired
    private AlapRepository alapRepository;
    @Autowired
    private FeltetRepository feltetRepository;

    //GET HOZZAVALOK
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

    //DELETE HOZZAVALOK

    public ResponseEntity<Pizza> deleteFeltet(Long pizzaid, Long feltetid) {
        Optional<Pizza> optionalPizza = rRepository.findById(pizzaid);
        Optional<Feltet> optionalFeltet = feltetRepository.findById(feltetid);
        if (optionalPizza.isPresent() && optionalFeltet.isPresent()) {
            List<Feltet> feltetek = optionalPizza.get().getFeltetek();
            if (feltetek != null && feltetek.contains(optionalFeltet.get())) {
                List<Pizza> pizzak = optionalFeltet.get().getPizzak();
                pizzak.remove(optionalPizza.get());
                optionalFeltet.get().setPizzak(pizzak);
                feltetRepository.save(optionalFeltet.get());
                feltetek.remove(optionalFeltet.get());
                optionalPizza.get().setFeltetek(feltetek);
                return ResponseEntity.ok(rRepository.save(optionalPizza.get()));
            }
        }
        return ResponseEntity.notFound().build();
    }

    //POST HOZZAVALOK
    public ResponseEntity<Pizza> postTeszta(Long pizzaid, Long tesztaid) {
        Optional<Pizza> optionalPizza = rRepository.findById(pizzaid);
        Optional<Teszta> ujoptionalTeszta = tesztaRepository.findById(tesztaid);
        if(optionalPizza.isPresent() && ujoptionalTeszta.isPresent()) {
            optionalPizza.get().setTeszta(ujoptionalTeszta.get());
            return ResponseEntity.ok(rRepository.save(optionalPizza.get()));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Pizza> postAlap(Long pizzaid, Long alapid) {
        Optional<Pizza> optionalPizza = rRepository.findById(pizzaid);
        Optional<Alap> ujoptionalAlap = alapRepository.findById(alapid);
        if(optionalPizza.isPresent() && ujoptionalAlap.isPresent()) {
            //a pizzat mented
            optionalPizza.get().setAlap(ujoptionalAlap.get());
            return ResponseEntity.ok(rRepository.save(optionalPizza.get()));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Pizza> postFeltet(Long pizzaid, Long feltetid) {
        Optional<Pizza> optionalPizza = rRepository.findById(pizzaid);
        Optional<Feltet> optionalFeltet = feltetRepository.findById(feltetid);
        if(optionalPizza.isPresent() && optionalFeltet.isPresent()) {
            List<Feltet> feltetek = optionalPizza.get().getFeltetek();
            if(!feltetek.contains(optionalFeltet.get())) {
                feltetek.add(optionalFeltet.get());
                optionalPizza.get().setFeltetek(feltetek);
                return ResponseEntity.ok(rRepository.save(optionalPizza.get()));
            } else {
                return ResponseEntity.status(HttpStatus.IM_USED).build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Pizza> postPizza(Map<String,Object> map) {
        System.out.println(map);
        List<String> feltetNevek = (ArrayList)map.get("feltetek");
        List<Feltet> feltetek = new ArrayList<>();
        try {
            for(String nev : feltetNevek) {
                feltetek.add(feltetRepository.findByNev(nev).get());
            }
            if (!rRepository.findByNev(map.get("nev").toString()).isPresent() && !rRepository.findByFeltetek(feltetek).isPresent()) {
                Pizza pizza = new Pizza();
                pizza.setAlap(alapRepository.findByNev(map.get("alap").toString()).get());
                pizza.setFeltetek(feltetek);
                pizza.setTeszta(tesztaRepository.findByNev(map.get("teszta").toString()).get());
                pizza.setUsers(Collections.emptyList());
                pizza.setNev(map.get("nev").toString());
                pizza.setAr(Integer.parseInt(map.get("ar").toString()));
                return ResponseEntity.ok(rRepository.save(pizza));
            }
        } catch (Exception e) {
            System.out.println("Hiba van a mátrixban!");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(HttpStatus.IM_USED).build();
    }


}
