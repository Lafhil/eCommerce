package com.ecommerce.services.impl;

import com.ecommerce.entities.ProductImages;
import com.ecommerce.entities.Products;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.services.interfaces.MannageServiceImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Primary
@Service("productService")
public class ProductService extends MannageServiceImpl<Products,Integer, ProductRepository> {
    @Override
    public Products saveOne(Products object) {
        if(object.getProductCategoriesByCategoryId()!=null){
            object.setProductCategoriesByCategoryId(object.getProductCategoriesByCategoryId());
            System.err.println("++++++++++++++++"+object.getProductCategoriesByCategoryId());
        }
      //  System.err.println(object.getProductCategoriesByCategoryId().getCategoryId()+"from service");
        if(object.getImageDecode()!=null)
            object.setPhoto(object.getImageDecode().getBytes());
        if(object.getImages()!=null)
        for (ProductImages img:object.getImages()
             ) {
            if(img.getImageDecode()!=null) {
                img.setImage(img.getImageDecode().getBytes());

            }
            img.setIdproduct(object);

            //System.err.println(img.getImageDecode());
        }
        return super.saveOne(object);
    }


    public List<Products> getByCritarea(Products product) {
        Example<Products>example=Example.of(product);
        List<Products> lst= this.getRep().findAll(example);

                if(product.getStatus()!=null  ) {
                    if(!product.getStatus().equals("All") )
                   lst= lst.stream().filter(p -> p.getStatus().equals(product.getStatus())).collect(Collectors.toList());
                }
                return lst;
    }
}
