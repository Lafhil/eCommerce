package com.ecommerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.MapsId;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
public class ProductsOptionsKey  implements Serializable {
    @Column(name = "ProductID")
    private Integer productID;
    @Column(name = "idOption")
    private Integer idOption;
    @MapsId("value")
    @Column(name = "value")
    private String value;
}
