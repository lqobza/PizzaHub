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
@Data
@Table(name = "alapok")
@EqualsAndHashCode(callSuper = false)
public class Alap extends BaseHozzatevo implements Serializable {

    public Alap(String nev, int ar) {
        this.nev = nev;
        this.ar = ar;
        this.pizzak = Collections.emptyList();
    }

    @JsonIgnore
    @OneToMany
    private List<Pizza> pizzak;
}
