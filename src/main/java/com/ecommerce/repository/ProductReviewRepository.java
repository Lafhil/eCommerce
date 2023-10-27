package com.ecommerce.repository;

import com.ecommerce.entities.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Integer> {
}