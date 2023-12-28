package com.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
public class ProductsOptions {
    @EmbeddedId
  private  ProductsOptionsKey productsOptionsKey;
    @ManyToOne
    @MapsId("productID")
    @JoinColumn(name = "ProductID")
    private Products products;

    @ManyToOne
    @MapsId("idOption")
    @JoinColumn(name = "idOption")
    private Options options;




}
