package com.ecommerce.services.impl;

import com.ecommerce.entities.Product;
import com.ecommerce.services.interfaces.MannageServiceImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("ProductService")
public class ProductService extends MannageServiceImpl<Product,Integer> {
}
