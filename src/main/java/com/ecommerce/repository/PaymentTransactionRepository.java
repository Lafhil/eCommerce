package com.ecommerce.repository;

import com.ecommerce.entities.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Integer> {
}