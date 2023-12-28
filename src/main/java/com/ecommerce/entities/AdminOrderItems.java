package com.ecommerce.entities;

import ch.qos.logback.core.boolex.EvaluationException;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Getter
@EqualsAndHashCode
public class AdminOrderItems {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AdminOrderItemID", nullable = false)
    private int adminOrderItemId;


    @Basic
    @Column(name = "Quantity", nullable = true)
    private Integer quantity;
    @Basic
    @Column(name = "Price", nullable = true, precision = 2)
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "AdminOrderID", referencedColumnName = "AdminOrderID")
    private AdminOrders adminOrdersByAdminOrderId;
    @JsonBackReference(value = "adminOrderItem")
    @ManyToOne
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    private Products productsByProductId;


}
