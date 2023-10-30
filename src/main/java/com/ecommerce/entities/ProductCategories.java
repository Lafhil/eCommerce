package com.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class ProductCategories {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CategoryID", nullable = false)
    private int categoryId;
    @Basic
    @Column(name = "CategoryName", nullable = true, length = 50)
    private String categoryName;
    @Lob
    private byte[] categorieImage;
    private String status;
    @ManyToOne
    @JsonBackReference(value = "categorieParent")
    @JoinColumn(name = "categorieParent",referencedColumnName = "CategoryID")
    private ProductCategories categorieParent;
    @JsonManagedReference(value = "product")
    @OneToMany(mappedBy = "productCategoriesByCategoryId")
    private Collection<Products> productsByCategoryId;
    @JsonManagedReference(value = "categorieParent")
    @OneToMany(mappedBy = "categorieParent")
    private Collection<ProductCategories> CategorieShilds;


}
