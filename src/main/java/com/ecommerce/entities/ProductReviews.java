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
public class ProductReviews {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ReviewID", nullable = false)
    private int reviewId;

    @Basic
    @Column(name = "Rating", nullable = true)
    private Integer rating;
    @Basic
    @Column(name = "ReviewText", nullable = true, length = -1)
    private String reviewText;
    @Basic
    @Column(name = "ReviewDate", nullable = true)
    private Date reviewDate;
    @ManyToOne
    @JsonBackReference(value = "productReview")
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    private Products productsByProductId;
    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    private Customers customersByCustomerId;


}
