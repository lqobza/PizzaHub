package com.example.PizzaHub.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = false)
public abstract class BaseHozzatevo extends BaseEntity {

    @NotNull
    @Column
    protected String nev;

    @NotNull
    @Column
    protected int ar;

}