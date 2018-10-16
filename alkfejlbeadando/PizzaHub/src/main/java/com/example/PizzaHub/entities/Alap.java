package com.example.PizzaHub.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "alapok")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Alap extends BaseHozzatevo implements Serializable {

    @JsonIgnore
    @OneToMany(targetEntity = Pizza.class,cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Pizza> pizzak;
}
