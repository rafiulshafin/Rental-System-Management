package com.Rental.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MaintenanceRequest {
    private Long id;
    private Long propertyId;
    private Long tenantId;
    private String description;
    private String status;
    private LocalDateTime requestDate;
    private LocalDateTime responseDate;
} 