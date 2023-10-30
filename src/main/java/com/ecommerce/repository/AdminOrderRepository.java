package com.ecommerce.repository;

import com.ecommerce.entities.AdminOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminOrderRepository extends JpaRepository<AdminOrders, Integer> {
}