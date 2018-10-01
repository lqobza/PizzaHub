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
import java.util.List;

@Entity
@Table(name = "tesztak")
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Teszta extends BaseHozzatevo implements Serializable {

    @JsonIgnore
    @OneToMany
    private List<Pizza> pizzak;
}
