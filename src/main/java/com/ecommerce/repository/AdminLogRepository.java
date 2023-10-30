package com.ecommerce.repository;

import com.ecommerce.entities.AdminLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminLogRepository extends JpaRepository<AdminLogs, Integer> {
}