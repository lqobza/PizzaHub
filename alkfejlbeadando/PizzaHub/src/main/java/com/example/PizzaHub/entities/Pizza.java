package com.example.PizzaHub.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "pizzak")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Pizza extends BaseHozzatevo implements Serializable {

    @JoinColumn(updatable = false)
    @JsonIgnore
    @ManyToOne(targetEntity = Teszta.class, cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Teszta teszta;

    @JoinColumn(updatable = false)
    @JsonIgnore
    @ManyToOne(targetEntity = Alap.class, cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Alap alap;

    @JsonIgnore
    @ManyToMany(targetEntity = Feltet.class,cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Feltet> feltetek;


    @JsonIgnore
    @ManyToMany(targetEntity = User.class,cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<User> users;

}
