package com.Rental.repository;

import com.Rental.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findByUsername(String username) {
        String sql = "SELECT id, username, password, email, full_name, roles, enabled FROM users WHERE username = ?";
        List<User> users = jdbcTemplate.query(sql, new Object[]{username}, new BeanPropertyRowMapper<>(User.class));
        return users.isEmpty() ? null : users.get(0);
    }

    public int save(User user) {
        String sql = "INSERT INTO users (username, password, email, full_name, roles, enabled) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getFullName(), user.getRoles(), user.isEnabled());
    }

    public int update(User user) {
        String sql = "UPDATE users SET password=?, email=?, full_name=?, roles=?, enabled=? WHERE username=?";
        return jdbcTemplate.update(sql, user.getPassword(), user.getEmail(), user.getFullName(), user.getRoles(), user.isEnabled(), user.getUsername());
    }
} 