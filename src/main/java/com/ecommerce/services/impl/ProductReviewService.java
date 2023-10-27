package com.ecommerce.services.impl;

import com.ecommerce.entities.ProductReview;
import com.ecommerce.services.interfaces.MannageServiceImpl;
import org.springframework.stereotype.Service;

@Service("productReviewService")
public class ProductReviewService extends MannageServiceImpl<ProductReview,Integer> {
}
