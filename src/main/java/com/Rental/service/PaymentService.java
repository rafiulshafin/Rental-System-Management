package com.Rental.service;

import com.Rental.model.Payment;
import com.Rental.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public int addPayment(Payment payment) {
        return paymentRepository.addPayment(payment);
    }

    public List<Payment> findByUserId(Long userId) {
        return paymentRepository.findByUserId(userId);
    }

    public List<Payment> findByAgreementId(Long agreementId) {
        return paymentRepository.findByAgreementId(agreementId);
    }
} 