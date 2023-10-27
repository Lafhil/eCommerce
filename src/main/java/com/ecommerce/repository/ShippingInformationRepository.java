package com.ecommerce.repository;

import com.ecommerce.entities.ShippingInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingInformationRepository extends JpaRepository<ShippingInformation, Integer> {
}