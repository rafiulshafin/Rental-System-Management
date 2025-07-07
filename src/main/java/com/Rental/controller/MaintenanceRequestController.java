package com.Rental.controller;

import com.Rental.model.MaintenanceRequest;
import com.Rental.service.MaintenanceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/maintenance-requests")
public class MaintenanceRequestController {
    @Autowired
    private MaintenanceRequestService maintenanceRequestService;

    @PostMapping
    public ResponseEntity<?> addRequest(@RequestBody MaintenanceRequest request) {
        int result = maintenanceRequestService.addRequest(request);
        if (result > 0) {
            return ResponseEntity.ok("Maintenance request submitted successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to submit maintenance request");
        }
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestParam String status) {
        int result = maintenanceRequestService.updateStatus(id, status);
        if (result > 0) {
            return ResponseEntity.ok("Maintenance request status updated to " + status);
        } else {
            return ResponseEntity.badRequest().body("Failed to update maintenance request status");
        }
    }

    @GetMapping("/property/{propertyId}")
    public ResponseEntity<List<MaintenanceRequest>> getByProperty(@PathVariable Long propertyId) {
        return ResponseEntity.ok(maintenanceRequestService.findByPropertyId(propertyId));
    }

    @GetMapping("/tenant/{tenantId}")
    public ResponseEntity<List<MaintenanceRequest>> getByTenant(@PathVariable Long tenantId) {
        return ResponseEntity.ok(maintenanceRequestService.findByTenantId(tenantId));
    }
} 