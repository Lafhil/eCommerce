package com.ecommerce.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Products {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    @Column(name = "ProductID", nullable = false)
    private Integer productId;
    @Basic
    @ToString.Include
    @Column(name = "ProductName", nullable = false, length = 100)
    private String productName;
    @Basic
    @ToString.Include
    @Column(name = "Description", nullable = false)
    private String description;
    @Basic
    @ToString.Include
    @Column(name = "Price", nullable = false)
    private BigDecimal price;
    @Lob
    @JsonBackReference("photo")
    private byte[] photo;
    @JsonManagedReference(value = "adminOrderItem")
    @OneToMany(mappedBy = "productsByProductId")
    private Collection<AdminOrderItems> adminOrderItemsByProductId;
    @JsonManagedReference(value = "productsByProductId")
    @OneToMany(mappedBy = "productsByProductId")
    private Collection<OrderItems> orderItemsByProductId;
    @JsonManagedReference(value = "productReview")
    @OneToMany(mappedBy = "productsByProductId")
    private Collection<ProductReviews> productReviewsByProductId;
    @ManyToOne()
  @JsonBackReference(value = "product")

   // @JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@Id")
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
    private ProductCategories productCategoriesByCategoryId;

    public String getCategorie() {
        if(this.productCategoriesByCategoryId!=null)
        return this.productCategoriesByCategoryId.getCategoryName();
        else return null;
    }

    public String getStatus() {
if(this.stock!=null)
            if(this.stock>=10)
                    this.status= "INSTOCK";
                else if( stock<5 )
                this.status= "LOWSTOCK";
                else if (stock==0 )
                this.status= "OUTOFSTOCK";
                return this.status;

    }

    @Transient
    @ToString.Include
    @Column(name = "status")
    private String status;
    @Basic()
    @ToString.Include
    @Column(name = "stock", nullable = false)
    private Integer  stock=null;
    @Transient
    @ToString.Include
    private String categorie;
    @JsonManagedReference(value = "productImage")
    @OneToMany(mappedBy = "idproduct",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Collection<ProductImages> images;
    //Code de l'article
    @ToString.Include
    private String skuCode;
    @ManyToOne
    private UniteMesure unite;
    //Qte Mininum pour une Commande
    @Basic
    @ToString.Include
    private Integer minOrderQte=null;
    @Basic
    @ToString.Include
    @Column(name = "unitePrice", nullable = false)
    private BigDecimal unitePrice;
    //prix de livraison
    @Basic
    @Column(name = "shipingConst", nullable = false, precision = 2)
    @ToString.Include
    private BigDecimal shipingConst;
    //prix de livraison Multiplier par Qte oui/non
    @Basic
    @Column(name = "shipMultQte",nullable = true)
    @ToString.Include
    private Boolean shipMultQte;
    //type de Remise forfait/pourcentage
    @Basic
    @ToString.Include
    private String discountType;
     @Basic
     @Column(nullable = false)
     @ToString.Include
     private BigDecimal discount;
    @Basic
    @Column(nullable = false)
    @ToString.Include
    private BigDecimal taxe;
    @Basic
    @ToString.Include
    private String LinkVideos;
    @Basic
    @ToString.Include
    private String tags;


    @Transient
    private String imageDecode;
    public String getImageDecode() {
        //System.err.println(this.categorieImage);
        if (this.photo != null) {
            if (this.imageDecode == null)
                this.imageDecode = new String(this.photo, StandardCharsets.UTF_8);
        }
        return this.imageDecode;
    }


}
