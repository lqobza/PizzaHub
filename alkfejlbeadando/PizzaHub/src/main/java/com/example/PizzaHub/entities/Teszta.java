package com.example.PizzaHub.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "tesztak")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Teszta extends BaseHozzatevo implements Serializable {

    @JsonIgnore
    @OneToMany(targetEntity = Pizza.class, cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Pizza> pizzak;
}
