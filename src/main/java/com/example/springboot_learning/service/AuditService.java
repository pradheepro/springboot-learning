package com.example.springboot_learning.service;
import com.example.springboot_learning.repository.AuditRepository;
import org.springframework.stereotype.Service;
import com.example.springboot_learning.entity.Audit;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuditService {

    public final AuditRepository auditRepository;

    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveAudit(String message) {
        auditRepository.save(new Audit(message));
    }
}
