package com.ecommerce.services.impl;

import com.ecommerce.entities.Products;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.services.interfaces.MannageServiceImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
@Primary
@Service("productService")
public class ProductService extends MannageServiceImpl<Products,Integer, ProductRepository> {

}
