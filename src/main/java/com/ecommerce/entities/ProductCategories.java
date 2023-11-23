package com.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Objects;

@Entity

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductCategories {
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CategoryID", nullable = false)
    private Integer categoryId;
    @Getter
    @Setter
    @Basic
    @Column(name = "CategoryName", nullable = true, length = 50)
    private String categoryName;
    @Getter
    @Setter
    @Basic
    @Column(name = "IsParent")
    private boolean isParent;
    @Getter
    @Setter
    @Basic
    @Column(name = "CategoryDesc", nullable = true, length = 300)
    private String categoryDesc;

    @Setter
    @Transient
    private String imageDecode;
    @Getter
    @Setter

    private byte[] categorieImage;
    @Getter
    @Setter
    private String status;
    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JsonBackReference(value = "categorieParent")
    @JoinColumn(name = "categorieParent",referencedColumnName = "CategoryID" )
    private ProductCategories categorieParent;
    @Getter
    @Setter
    @JsonManagedReference(value = "product")
    @OneToMany(mappedBy = "productCategoriesByCategoryId")
    private Collection<Products> productsByCategoryId;
    @Getter
    @Setter
    @JsonManagedReference(value = "categorieParent")
    @OneToMany(mappedBy = "categorieParent",cascade = CascadeType.ALL)
    private Collection<ProductCategories> categorieShilds;




    public String getImageDecode() {
        //System.err.println(this.categorieImage);
        if(this.categorieImage!=null ){
            if(this.imageDecode==null)
            this.imageDecode= new String(this.categorieImage, StandardCharsets.UTF_8);
        }


        return this.imageDecode;
    }
}
