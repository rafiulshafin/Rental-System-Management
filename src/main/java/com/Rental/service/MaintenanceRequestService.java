package com.Rental.service;

import com.Rental.model.MaintenanceRequest;
import com.Rental.repository.MaintenanceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MaintenanceRequestService {
    @Autowired
    private MaintenanceRequestRepository maintenanceRequestRepository;

    public int addRequest(MaintenanceRequest request) {
        return maintenanceRequestRepository.addRequest(request);
    }

    public int updateStatus(Long id, String status) {
        return maintenanceRequestRepository.updateStatus(id, status, LocalDateTime.now());
    }

    public List<MaintenanceRequest> findByPropertyId(Long propertyId) {
        return maintenanceRequestRepository.findByPropertyId(propertyId);
    }

    public List<MaintenanceRequest> findByTenantId(Long tenantId) {
        return maintenanceRequestRepository.findByTenantId(tenantId);
    }
} 