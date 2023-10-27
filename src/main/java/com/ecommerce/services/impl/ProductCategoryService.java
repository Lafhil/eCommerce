package com.ecommerce.services.impl;

import com.ecommerce.entities.ProductCategory;
import com.ecommerce.services.interfaces.MannageServiceImpl;
import org.springframework.stereotype.Service;

@Service("productCategoryService")
public class ProductCategoryService extends MannageServiceImpl<ProductCategory,Integer> {
}
