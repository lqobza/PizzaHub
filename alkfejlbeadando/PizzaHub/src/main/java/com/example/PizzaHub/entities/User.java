package com.example.PizzaHub.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity implements Serializable {

    @NotNull
    @Column
    private String userName;

    @NotNull
    @Column
    private String password;

    @NotNull
    @Column
    private String emailAddress;

    @NotNull
    @Column
    private Role role;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Pizza> pizzak;


}
