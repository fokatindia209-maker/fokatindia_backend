// =========================================
// CATEGORY DTOs
// =========================================

package com.fokatindia.vendor_service.dto;

import lombok.Data;

@Data
public class CategoryRequest {

    private String name;

    private String description;

    private String imageUrl;

    private Integer displayOrder;

    private String slug;
}