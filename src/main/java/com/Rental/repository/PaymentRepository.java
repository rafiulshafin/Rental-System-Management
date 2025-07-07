package com.Rental.repository;

import com.Rental.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PaymentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addPayment(Payment payment) {
        String sql = "INSERT INTO payments (agreement_id, payer_id, payee_id, amount, payment_date, status) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, payment.getAgreementId(), payment.getPayerId(), payment.getPayeeId(), payment.getAmount(), payment.getPaymentDate(), payment.getStatus());
    }

    public List<Payment> findByUserId(Long userId) {
        String sql = "SELECT * FROM payments WHERE payer_id = ? OR payee_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId, userId}, new BeanPropertyRowMapper<>(Payment.class));
    }

    public List<Payment> findByAgreementId(Long agreementId) {
        String sql = "SELECT * FROM payments WHERE agreement_id = ?";
        return jdbcTemplate.query(sql, new Object[]{agreementId}, new BeanPropertyRowMapper<>(Payment.class));
    }
} 