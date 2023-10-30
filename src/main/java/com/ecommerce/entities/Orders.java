package com.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter @Setter
@EqualsAndHashCode
public class Orders {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "OrderID", nullable = false)
    private int orderId;

    @Basic
    @Column(name = "OrderDate", nullable = true)
    private Date orderDate;
    @Basic
    @Column(name = "TotalAmount", nullable = true, precision = 2)
    private BigDecimal totalAmount;
    @JsonManagedReference(value = "orderItem")
    @OneToMany(mappedBy = "ordersByOrderId")
    private Collection<OrderItems> orderItemsByOrderId;
    @JsonBackReference(value = "order")
    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    private Customers customersByCustomerId;
    @JsonManagedReference(value = "paymentTransaction")
    @OneToMany(mappedBy = "ordersByOrderId")
    private Collection<PaymentTransactions> paymentTransactionsByOrderId;
    @JsonManagedReference(value = "shippingInformation")
    @OneToMany(mappedBy = "ordersByOrderId")
    private Collection<ShippingInformation> shippingInformationsByOrderId;


}
