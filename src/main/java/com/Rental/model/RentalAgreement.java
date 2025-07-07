package com.Rental.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class RentalAgreement {
    private Long id;
    private Long propertyId;
    private Long landlordId;
    private Long tenantId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double rentAmount;
    private LocalDate agreementDate;
} 