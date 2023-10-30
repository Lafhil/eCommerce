package com.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class ProductImages {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer imageId;
    @ManyToOne
    //@JsonBackReference(value = "OrderItem")
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    private Products idproduct;
}
