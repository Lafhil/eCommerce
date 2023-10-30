package com.ecommerce.repository;

import com.ecommerce.entities.Orders;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Primary
@Repository
public interface OrderRepo extends JpaRepository<Orders,Integer> {
}
