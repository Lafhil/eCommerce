package com.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class ShippingInformation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ShippingID", nullable = false)
    private int shippingId;

    @Basic
    @Column(name = "ShipDate", nullable = true)
    private Date shipDate;
    @Basic
    @Column(name = "ShipAddress", nullable = true, length = 255)
    private String shipAddress;
    @JsonBackReference(value = "shippingInformation")
    @ManyToOne
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID")
    private Orders ordersByOrderId;


}
