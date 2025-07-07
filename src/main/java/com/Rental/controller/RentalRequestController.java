package com.Rental.controller;

import com.Rental.model.RentalRequest;
import com.Rental.service.RentalRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rental-requests")
public class RentalRequestController {
    @Autowired
    private RentalRequestService rentalRequestService;

    @PostMapping
    public ResponseEntity<?> addRentalRequest(@RequestBody RentalRequest request) {
        int result = rentalRequestService.addRentalRequest(request);
        if (result > 0) {
            return ResponseEntity.ok("Rental request submitted successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to submit rental request");
        }
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateRentalRequestStatus(@PathVariable Long id, @RequestParam String status) {
        int result = rentalRequestService.updateRentalRequestStatus(id, status);
        if (result > 0) {
            return ResponseEntity.ok("Rental request status updated to " + status);
        } else {
            return ResponseEntity.badRequest().body("Failed to update rental request status");
        }
    }
} 