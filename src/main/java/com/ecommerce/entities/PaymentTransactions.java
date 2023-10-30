package com.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class PaymentTransactions {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TransactionID", nullable = false)
    private int transactionId;


    @Basic
    @Column(name = "Amount", nullable = true, precision = 2)
    private BigDecimal amount;
    @Basic
    @Column(name = "TransactionDate", nullable = true)
    private Date transactionDate;
    @Basic
    @Column(name = "TransactionStatus", nullable = true, length = 20)
    private String transactionStatus;
    @JsonBackReference(value = "paymentTransaction")
    @ManyToOne
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID")
    private Orders ordersByOrderId;
    @ManyToOne
    @JoinColumn(name = "PaymentMethodID", referencedColumnName = "PaymentMethodID")
    private PaymentMethods paymentMethodsByPaymentMethodId;


}
