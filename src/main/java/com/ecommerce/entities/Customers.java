package com.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Customers {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CustomerID", nullable = false)
    private int customerId;
    @Basic
    @Column(name = "FirstName", nullable = true, length = 50)
    private String firstName;
    @Basic
    @Column(name = "LastName", nullable = true, length = 50)
    private String lastName;
    @Basic
    @Column(name = "Email", nullable = true, length = 100)
    private String email;
    @Basic
    @Column(name = "Password", nullable = true, length = 255)
    private String password;
    @Basic
    @Column(name = "Address", nullable = true, length = 255)
    private String address;
    @Basic
    @Column(name = "PhoneNumber", nullable = true, length = 20)
    private String phoneNumber;
    @OneToMany(mappedBy = "customersByCustomerId")
    private Collection<AdminOrders> adminOrdersByCustomerId;
    @JsonManagedReference(value = "order")

    @OneToMany(mappedBy = "customersByCustomerId")
    private Collection<Orders> ordersByCustomerId;
    @OneToMany(mappedBy = "customersByCustomerId")
    private Collection<PaymentMethods> paymentMethodsByCustomerId;
    @OneToMany(mappedBy = "customersByCustomerId")
    private Collection<ProductReviews> productReviewsByCustomerId;


}
