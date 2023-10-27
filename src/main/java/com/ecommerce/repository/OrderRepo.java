package com.ecommerce.repository;

import com.ecommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface OrderRepo extends JpaRepository<Order,Integer> {
}
