package com.example.PizzaHub.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "feltetek")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Feltet extends BaseHozzatevo implements Serializable {


    @JsonIgnore
    @ManyToMany(targetEntity = Pizza.class,cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    protected List<Pizza> pizzak;

}
