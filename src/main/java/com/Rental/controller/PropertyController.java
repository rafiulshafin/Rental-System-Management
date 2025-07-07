package com.Rental.controller;

import com.Rental.model.Property;
import com.Rental.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping
    public ResponseEntity<?> addProperty(@RequestBody Property property) {
        int result = propertyService.addProperty(property);
        if (result > 0) {
            return ResponseEntity.ok("Property added successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to add property");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProperty(@PathVariable Long id, @RequestBody Property property) {
        property.setId(id);
        int result = propertyService.updateProperty(property);
        if (result > 0) {
            return ResponseEntity.ok("Property updated successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to update property");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProperty(@PathVariable Long id) {
        int result = propertyService.deleteProperty(id);
        if (result > 0) {
            return ResponseEntity.ok("Property deleted successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to delete property");
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllProperties() {
        return ResponseEntity.ok(propertyService.getAllProperties());
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchProperties(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) Double minRent,
            @RequestParam(required = false) Double maxRent) {
        return ResponseEntity.ok(propertyService.searchProperties(type, address, minRent, maxRent));
    }

    @PostMapping("/send-test-email")
    public ResponseEntity<?> sendTestEmail(@RequestParam String toEmail) {
        // ...
        return null;
    }
} 