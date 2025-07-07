package com.Rental.model;

import lombok.Data;

@Data
public class Property {
    private Long id;
    private String title;
    private String address;
    private String type;
    private Double rent;
    private String description;
    private Long ownerId;
} 