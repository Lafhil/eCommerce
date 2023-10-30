package com.ecommerce.controlers;

import com.ecommerce.controlers.Interface.GenericController;
import com.ecommerce.entities.Products;
import com.ecommerce.services.impl.ProductService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class ProductControler extends GenericController<Products, Integer, ProductService> {

}
