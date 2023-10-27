package com.ecommerce.repository;

import com.ecommerce.entities.AdminLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminLogRepository extends JpaRepository<AdminLog, Integer> {
}