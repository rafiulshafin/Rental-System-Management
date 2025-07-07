package com.Rental.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String fullName;
    private String roles;
    private boolean enabled;
} 