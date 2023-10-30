package com.ecommerce.repository;

import com.ecommerce.entities.Administrators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrators, Integer> {
}