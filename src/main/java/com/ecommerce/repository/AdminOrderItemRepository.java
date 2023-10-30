package com.ecommerce.repository;

import com.ecommerce.entities.AdminOrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminOrderItemRepository extends JpaRepository<AdminOrderItems, Integer> {
}