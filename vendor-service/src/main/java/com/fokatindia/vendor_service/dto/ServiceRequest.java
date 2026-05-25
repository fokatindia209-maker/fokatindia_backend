package com.fokatindia.vendor_service.dto;

// ================================
// DTOs
// ================================


import lombok.Data;

import java.math.BigDecimal;

@Data
public class ServiceRequest {

    private Long categoryId;

    private String name;

    private String description;

    private Double price;

    private Double discountedPrice;

    private Integer durationMinutes;

    private String imageUrl;

    private Boolean featured;

    private String serviceType;
}