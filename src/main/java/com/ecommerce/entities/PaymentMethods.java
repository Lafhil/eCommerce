package com.ecommerce.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class PaymentMethods {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PaymentMethodID", nullable = false)
    private int paymentMethodId;

    @Basic
    @Column(name = "CardNumber", nullable = true, length = 16)
    private String cardNumber;
    @Basic
    @Column(name = "ExpiryDate", nullable = true)
    private Date expiryDate;
    @Basic
    @Column(name = "CVV", nullable = true)
    private Integer cvv;
    @Basic
    @Column(name = "BillingAddress", nullable = true, length = 255)
    private String billingAddress;
    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    private Customers customersByCustomerId;
    @OneToMany(mappedBy = "paymentMethodsByPaymentMethodId")
    private Collection<PaymentTransactions> paymentTransactionsByPaymentMethodId;

}
