package com.ecommerce.controlers;

import com.ecommerce.controlers.Interface.GenericController;
import com.ecommerce.entities.Products;
import com.ecommerce.services.impl.ProductService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class ProductControler extends GenericController<Products, Integer, ProductService> {
@PostMapping("/getByFilter")
    public List<Products> getByFilter(@RequestBody Products products){
    //System.err.println("product Filter"+products.getProductCategoriesByCategoryId().getCategoryId()+"products id"+products.getProductId());
  //System.err.println(products);
    return this.getService().getByCritarea(products);
}
}
