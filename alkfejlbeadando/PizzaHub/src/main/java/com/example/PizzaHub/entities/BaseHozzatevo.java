package com.example.PizzaHub.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public abstract class BaseHozzatevo extends BaseEntity {

    @NotNull
    @Column
    protected String nev;

    @NotNull
    @Column
    protected int ar;

}