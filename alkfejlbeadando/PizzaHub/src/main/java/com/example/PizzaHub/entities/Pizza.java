package com.example.PizzaHub.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "pizzak")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Pizza extends BaseHozzatevo implements Serializable {

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
    private String nev = "";

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<User> users;

}
