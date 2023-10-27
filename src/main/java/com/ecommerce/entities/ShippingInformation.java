package com.ecommerce.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;

@Entity
public class ShippingInformation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShippingID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderID")
    private Order orderID;

    @Column(name = "ShipDate")
    private Instant shipDate;

    @Column(name = "ShipAddress")
    private String shipAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrderID() {
        return orderID;
    }

    public void setOrderID(Order orderID) {
        this.orderID = orderID;
    }

    public Instant getShipDate() {
        return shipDate;
    }

    public void setShipDate(Instant shipDate) {
        this.shipDate = shipDate;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

}