package com.example.PizzaHub.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "tesztak")
@Data
@EqualsAndHashCode(callSuper = false)
public class Teszta extends BaseHozzatevo implements Serializable {

    public Teszta(String nev, int ar) {
        this.nev = nev;
        this.ar = ar;
        this.pizzak = Collections.emptyList();
    }

    @JsonIgnore
    @OneToMany
    private List<Pizza> pizzak;
}
