package com.example.PizzaHub.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "pizzak")
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Pizza extends BaseHozzatevo implements Serializable {

    public Pizza(String nev, int ar, Teszta teszta, Alap alap, List<Feltet> feltetek) {
        this.nev = nev;
        this.ar = ar;
        this.teszta = teszta;
        this.alap = alap;
        this.feltetek = feltetek;
        this.users = Collections.emptyList();
    }

    @JsonIgnore
    @ManyToOne
    private Teszta teszta;

    @JsonIgnore
    @ManyToOne
    private Alap alap;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Feltet> feltetek;

    @Column
    @NotNull
    private String nev = "";

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<User> users;

}
