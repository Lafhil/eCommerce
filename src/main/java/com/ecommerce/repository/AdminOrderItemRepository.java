package com.ecommerce.repository;

import com.ecommerce.entities.AdminOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminOrderItemRepository extends JpaRepository<AdminOrderItem, Integer> {
}