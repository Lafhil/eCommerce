package com.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class OrderItems {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "OrderItemID", nullable = false)
    private int orderItemId;

    @Basic
    @Column(name = "Quantity", nullable = true)
    private Integer quantity;
    @Basic
    @Column(name = "Price", nullable = true)
    private BigDecimal price;
    @JsonBackReference(value = "OrderItem")
    @ManyToOne
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID")
    private Orders ordersByOrderId;
    @ManyToOne
    @JsonBackReference (value = "OrderItem")
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    private Products productsByProductId;


}
