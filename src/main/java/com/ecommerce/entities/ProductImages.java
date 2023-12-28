package com.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.nio.charset.StandardCharsets;

@Entity
@Getter
@Setter
//@EqualsAndHashCode
public class ProductImages {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer imageId;
    @JsonBackReference("image")
    private byte[] image;


    @Transient
    private String imageDecode;
    @ManyToOne
    @JsonBackReference(value = "productImage")
   // @JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@Id")
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    private Products idproduct;

    public String getImageDecode() {
        //System.err.println(this.categorieImage);
        if (this.image != null) {
            if (this.imageDecode == null) {
                this.imageDecode = new String(this.image, StandardCharsets.UTF_8);
                System.err.println("ok");
            }
        }

        return this.imageDecode;
    }

}
