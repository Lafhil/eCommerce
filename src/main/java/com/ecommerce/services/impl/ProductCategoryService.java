package com.ecommerce.services.impl;

import com.ecommerce.entities.ProductCategories;
import com.ecommerce.repository.ProductCategoryRepository;
import com.ecommerce.services.interfaces.MannageServiceImpl;
import org.springframework.stereotype.Service;

@Service("productCategoryService")
public class ProductCategoryService extends MannageServiceImpl<ProductCategories,Integer, ProductCategoryRepository> {
}
