package com.ecommerce.services.impl;

import com.ecommerce.entities.ProductReviews;
import com.ecommerce.repository.ProductReviewRepository;
import com.ecommerce.services.interfaces.MannageServiceImpl;
import org.springframework.stereotype.Service;

@Service("productReviewService")
public class ProductReviewService extends MannageServiceImpl<ProductReviews,Integer, ProductReviewRepository> {
}
