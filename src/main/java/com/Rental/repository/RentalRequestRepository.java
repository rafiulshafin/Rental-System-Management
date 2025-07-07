package com.Rental.repository;

import com.Rental.model.RentalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RentalRequestRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addRentalRequest(RentalRequest request) {
        String sql = "INSERT INTO rental_requests (property_id, tenant_id, status, request_date) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, request.getPropertyId(), request.getTenantId(), request.getStatus(), request.getRequestDate());
    }

    public int updateRentalRequestStatus(Long id, String status) {
        String sql = "UPDATE rental_requests SET status=? WHERE id=?";
        return jdbcTemplate.update(sql, status, id);
    }
} 