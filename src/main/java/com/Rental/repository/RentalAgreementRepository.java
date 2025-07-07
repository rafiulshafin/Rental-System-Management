package com.Rental.repository;

import com.Rental.model.RentalAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class RentalAgreementRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<RentalAgreement> findByUserId(Long userId) {
        String sql = "SELECT * FROM rental_agreements WHERE landlord_id = ? OR tenant_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId, userId}, new BeanPropertyRowMapper<>(RentalAgreement.class));
    }
} 