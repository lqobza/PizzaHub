package com.example.PizzaHub.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "feltetek")
@Data
@EqualsAndHashCode(callSuper = false)
public class Feltet extends BaseHozzatevo implements Serializable {

    public Feltet(String nev, int ar) {
        this.nev = nev;
        this.ar = ar;
        this.pizzak = Collections.emptyList();
    }

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    protected List<Pizza> pizzak;

}
