package com.Rental.service;

import com.Rental.model.RentalAgreement;
import com.Rental.repository.RentalAgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RentalAgreementService {
    @Autowired
    private RentalAgreementRepository rentalAgreementRepository;

    public List<RentalAgreement> findByUserId(Long userId) {
        return rentalAgreementRepository.findByUserId(userId);
    }
} 