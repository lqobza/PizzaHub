package com.example.PizzaHub.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity implements Serializable {

    public User(String userName, String password,String emailAddress,Role role) {
        this.userName = userName;
        this.password = password;
        this.emailAddress = emailAddress;
        this.role = role;
    }

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
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Pizza> pizzak;


}
