package com.Rental.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class RentalRequest {
    private Long id;
    private Long propertyId;
    private Long tenantId;
    private String status; // e.g., PENDING, APPROVED, REJECTED
    private LocalDateTime requestDate;
} 