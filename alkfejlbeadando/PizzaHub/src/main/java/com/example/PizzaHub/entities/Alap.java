package com.example.PizzaHub.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "alapok")
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Alap extends BaseHozzatevo implements Serializable {

    @JsonIgnore
    @OneToMany
    private List<Pizza> pizzak;
}
