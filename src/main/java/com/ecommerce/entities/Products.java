package com.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Products {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ProductID", nullable = false)
    private int productId;
    @Basic
    @Column(name = "ProductName", nullable = true, length = 100)
    private String productName;
    @Basic
    @Column(name = "Description", nullable = true, length = -1)
    private String description;
    @Basic
    @Column(name = "Price", nullable = true, precision = 2)
    private BigDecimal price;
    @Lob
    private byte[] photo;
@JsonManagedReference(value = "adminOrderItem")
    @OneToMany(mappedBy = "productsByProductId")
    private Collection<AdminOrderItems> adminOrderItemsByProductId;
    @JsonManagedReference(value = "OrderItem")
    @OneToMany(mappedBy = "productsByProductId")
    private Collection<OrderItems> orderItemsByProductId;
    @JsonManagedReference(value = "productReview")
    @OneToMany(mappedBy = "productsByProductId")
    private Collection<ProductReviews> productReviewsByProductId;
    @ManyToOne
    @JsonBackReference(value = "product")
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
    private ProductCategories productCategoriesByCategoryId;

    //@JsonManagedReference(value = "OrderItem")
    @OneToMany(mappedBy = "idproduct")
    private Collection<ProductImages> images;

}
