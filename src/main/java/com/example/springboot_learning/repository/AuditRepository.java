package com.example.springboot_learning.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springboot_learning.entity.Audit;

public interface AuditRepository extends JpaRepository <Audit,Long> {

}
