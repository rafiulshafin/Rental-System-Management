package com.Rental.controller;

import com.Rental.model.RentalAgreement;
import com.Rental.service.RentalAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rental-agreements")
public class RentalAgreementController {
    @Autowired
    private RentalAgreementService rentalAgreementService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RentalAgreement>> getAgreementsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(rentalAgreementService.findByUserId(userId));
    }
} 