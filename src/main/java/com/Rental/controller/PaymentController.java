package com.Rental.controller;

import com.Rental.model.Payment;
import com.Rental.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<?> addPayment(@RequestBody Payment payment) {
        int result = paymentService.addPayment(payment);
        if (result > 0) {
            return ResponseEntity.ok("Payment recorded successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to record payment");
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Payment>> getPaymentsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(paymentService.findByUserId(userId));
    }

    @GetMapping("/agreement/{agreementId}")
    public ResponseEntity<List<Payment>> getPaymentsByAgreement(@PathVariable Long agreementId) {
        return ResponseEntity.ok(paymentService.findByAgreementId(agreementId));
    }
} 