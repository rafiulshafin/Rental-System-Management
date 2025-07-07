package com.Rental.service;

import com.Rental.model.Property;
import com.Rental.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    public int addProperty(Property property) {
        return propertyRepository.addProperty(property);
    }

    public int deleteProperty(Long id) {
        return propertyRepository.deleteProperty(id);
    }

    public List<Property> getAllProperties() {
        return propertyRepository.getAllProperties();
    }

    public List<Property> searchProperties(String type, String address, Double minRent, Double maxRent) {
        return propertyRepository.searchProperties(type, address, minRent, maxRent);
    }

    public int updateProperty(Property property) {
        return propertyRepository.updateProperty(property);
    }
} 