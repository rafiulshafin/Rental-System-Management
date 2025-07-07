package com.Rental.repository;

import com.Rental.model.MaintenanceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MaintenanceRequestRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addRequest(MaintenanceRequest request) {
        String sql = "INSERT INTO maintenance_requests (property_id, tenant_id, description, status, request_date) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, request.getPropertyId(), request.getTenantId(), request.getDescription(), request.getStatus(), request.getRequestDate());
    }

    public int updateStatus(Long id, String status, java.time.LocalDateTime responseDate) {
        String sql = "UPDATE maintenance_requests SET status=?, response_date=? WHERE id=?";
        return jdbcTemplate.update(sql, status, responseDate, id);
    }

    public List<MaintenanceRequest> findByPropertyId(Long propertyId) {
        String sql = "SELECT * FROM maintenance_requests WHERE property_id = ?";
        return jdbcTemplate.query(sql, new Object[]{propertyId}, new BeanPropertyRowMapper<>(MaintenanceRequest.class));
    }

    public List<MaintenanceRequest> findByTenantId(Long tenantId) {
        String sql = "SELECT * FROM maintenance_requests WHERE tenant_id = ?";
        return jdbcTemplate.query(sql, new Object[]{tenantId}, new BeanPropertyRowMapper<>(MaintenanceRequest.class));
    }
} 