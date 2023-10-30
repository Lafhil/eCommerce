package com.ecommerce.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class AdminOrders {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AdminOrderID", nullable = false)
    private int adminOrderId;

    @Basic
    @Column(name = "OrderDate", nullable = true)
    private Date orderDate;
    @Basic
    @Column(name = "TotalAmount", nullable = true, precision = 2)
    private BigDecimal totalAmount;
    @Basic
    @Column(name = "OrderStatus", nullable = true, length = 20)
    private String orderStatus;
    @OneToMany(mappedBy = "adminOrdersByAdminOrderId")
    private Collection<AdminOrderItems> adminOrderItemsByAdminOrderId;
    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    private Customers customersByCustomerId;


}
