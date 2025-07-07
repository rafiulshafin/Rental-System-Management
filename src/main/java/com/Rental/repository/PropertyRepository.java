package com.Rental.repository;

import com.Rental.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PropertyRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addProperty(Property property) {
        String sql = "INSERT INTO properties (title, address, type, rent, description, owner_id) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, property.getTitle(), property.getAddress(), property.getType(), property.getRent(), property.getDescription(), property.getOwnerId());
    }

    public int updateProperty(Property property) {
        String sql = "UPDATE properties SET title=?, address=?, type=?, rent=?, description=?, owner_id=? WHERE id=?";
        return jdbcTemplate.update(sql, property.getTitle(), property.getAddress(), property.getType(), property.getRent(), property.getDescription(), property.getOwnerId(), property.getId());
    }

    public int deleteProperty(Long id) {
        String sql = "DELETE FROM properties WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }

    public List<Property> getAllProperties() {
        String sql = "SELECT * FROM properties";
        return jdbcTemplate.query(sql, new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Property.class));
    }

    public List<Property> searchProperties(String type, String address, Double minRent, Double maxRent) {
        StringBuilder sql = new StringBuilder("SELECT * FROM properties WHERE 1=1");
        List<Object> params = new java.util.ArrayList<>();
        if (type != null && !type.isEmpty()) {
            sql.append(" AND type ILIKE ?");
            params.add("%" + type + "%");
        }
        if (address != null && !address.isEmpty()) {
            sql.append(" AND address ILIKE ?");
            params.add("%" + address + "%");
        }
        if (minRent != null) {
            sql.append(" AND rent >= ?");
            params.add(minRent);
        }
        if (maxRent != null) {
            sql.append(" AND rent <= ?");
            params.add(maxRent);
        }
        return jdbcTemplate.query(sql.toString(), params.toArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(Property.class));
    }
} 