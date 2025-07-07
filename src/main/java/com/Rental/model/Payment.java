package com.Rental.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Payment {
    private Long id;
    private Long agreementId;
    private Long payerId;
    private Long payeeId;
    private Double amount;
    private LocalDateTime paymentDate;
    private String status; // e.g., PAID, PENDING
} 