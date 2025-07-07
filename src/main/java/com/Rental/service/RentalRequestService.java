package com.Rental.service;

import com.Rental.model.RentalRequest;
import com.Rental.repository.RentalRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalRequestService {
    @Autowired
    private RentalRequestRepository rentalRequestRepository;

    public int addRentalRequest(RentalRequest request) {
        return rentalRequestRepository.addRentalRequest(request);
    }

    public int updateRentalRequestStatus(Long id, String status) {
        return rentalRequestRepository.updateRentalRequestStatus(id, status);
    }
} 