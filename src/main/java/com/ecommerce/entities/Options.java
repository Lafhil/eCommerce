package com.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOption")
    private Integer idOption;
    @Column(name = "descrptionOption")
    private String descrptionOption;

}
