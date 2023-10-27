package com.ecommerce.repository;

import com.ecommerce.entities.AdminOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminOrderRepository extends JpaRepository<AdminOrder, Integer> {
}