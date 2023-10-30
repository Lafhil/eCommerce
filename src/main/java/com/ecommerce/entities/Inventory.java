package com.ecommerce.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Inventory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ProductID", nullable = false)
    private int productId;
    @Basic
    @Column(name = "StockQuantity", nullable = true)
    private Integer stockQuantity;



}
