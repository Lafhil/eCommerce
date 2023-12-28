package com.ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class UniteMesure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUnite;
    private String desCription;

}
